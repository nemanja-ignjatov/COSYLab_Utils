package fog.faca.access_rules.rule_types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fog.faca.access_rules.AccessRuleType;
import fog.faca.access_rules.IAccessRule;
import fog.faca.access_rules.ISimpleAccessRule;
import fog.payloads.faca.PDP.AttributeEvaluationConfiguration;
import fog.payloads.faca.PDP.AttributeValueWrapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class ContextAccessRule implements IAccessRule {

    private AccessRuleType type = AccessRuleType.CONTEXT;
    private ISimpleAccessRule accessRule;
    private NumericAccessRule expectedCertaintyRule;
    private String attributeName;
    private boolean isAttributeValueTimeCritical;

    public ContextAccessRule(ISimpleAccessRule accessRule, NumericAccessRule expectedCertainty, String attributeName) {
        this.accessRule = accessRule;
        this.expectedCertaintyRule = expectedCertainty;
        this.attributeName = attributeName;
    }

    public ContextAccessRule(JsonNode jsonNode) throws IOException {

        this.expectedCertaintyRule = new NumericAccessRule(jsonNode.get("expectedCertaintyRule"));
        this.attributeName = jsonNode.get("attributeName").asText();
        this.isAttributeValueTimeCritical = jsonNode.get("attributeValueTimeCritical").asBoolean(false);
        JsonNode ruleJsonNode = jsonNode.get("accessRule");
        AccessRuleType ruleType = AccessRuleType.valueOf(ruleJsonNode.get("accessRuleType").asText());
        switch (ruleType) {
            case BOOLEAN:
                this.accessRule = new BooleanAccessRule(ruleJsonNode);
                break;
            case NUMERIC:
                this.accessRule = new NumericAccessRule(ruleJsonNode);
                break;
            case STRING:
                this.accessRule = new StringAccessRule(ruleJsonNode);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean isValidAgainstAttributes(Map<String, AttributeValueWrapper> ruleAttrs) {

        AttributeValueWrapper controllerValueWrapper = ruleAttrs.get(this.attributeName);
        if (controllerValueWrapper == null) {
            return false;
        }

        if(controllerValueWrapper.isAuthzDecision() != null) {
            return controllerValueWrapper.isAuthzDecision();
        }

        return this.accessRule.isValidAgainstAttributes(Map.of(this.attributeName, controllerValueWrapper))
                && this.expectedCertaintyRule.isValidAgainstAttributes(Map.of(this.attributeName, new AttributeValueWrapper(String.valueOf(controllerValueWrapper.getCertainty()))));
    }

    @Override
    public String convertToJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public List<AttributeEvaluationConfiguration> getAttributeEvaluationInfo() {
        return this.accessRule.getAttributeEvaluationInfo().stream()
                .map(ar -> new AttributeEvaluationConfiguration(ar.getAttributeName(), true, this.isAttributeValueTimeCritical))
                .collect(Collectors.toList());
    }

    @Override
    public void updateAttributeNames(String currentAttributeName, String newAttributeName) {
        this.accessRule.updateAttributeNames(currentAttributeName, newAttributeName);
    }
}
