package fog.faca.access_rules.rule_types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fog.faca.access_rules.AccessRuleType;
import fog.faca.access_rules.ISimpleAccessRule;
import fog.payloads.faca.PDP.AttributeEvaluationConfiguration;
import fog.payloads.faca.PDP.AttributeValueWrapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class StringAccessRule implements ISimpleAccessRule {

    private String attributeName;
    private String expectedValue;
    private StringAccessRuleOperator operator;
    private AccessRuleType type = AccessRuleType.STRING;

    public StringAccessRule(String expectedValue, String attributeName, StringAccessRuleOperator operator) {
        this.expectedValue = expectedValue;
        this.attributeName = attributeName;
        this.operator = operator;
    }

    public StringAccessRule(String accessRuleJson) throws IOException {
        ObjectMapper objMapper = new ObjectMapper();
        StringAccessRule strARObj = objMapper.readValue(accessRuleJson, StringAccessRule.class);
        this.expectedValue = strARObj.expectedValue;
        this.attributeName = strARObj.attributeName;
        this.operator = strARObj.operator;
    }

    public StringAccessRule(JsonNode node) {
        this.expectedValue = node.get("expectedValue").asText();
        this.attributeName = node.get("attributeName").asText();
        this.operator = StringAccessRuleOperator.valueOf(node.get("operator").asText());
    }

    @Override
    public boolean isValidAgainstAttributes(Map<String, AttributeValueWrapper> userAttrs) {

        AttributeValueWrapper controllerValueWrapper = userAttrs.get(attributeName);
        if(controllerValueWrapper == null) {
            return false;
        }
        String controlledVal = controllerValueWrapper.getValue();

        if ((controlledVal != null) &&
                validateStringAttributeValue(this.expectedValue, controlledVal, this.operator)) {
            return true;
        }

        return false;

    }

    @Override
    public List<AttributeEvaluationConfiguration> getAttributeEvaluationInfo() {
        return List.of(new AttributeEvaluationConfiguration(this.attributeName));
    }

    @Override
    public void updateAttributeNames(String currentAttributeName, String newAttributeName) {
        if(this.attributeName.equals(currentAttributeName)) {
            this.attributeName = newAttributeName;
        }
    }

    @Override
    public String convertToJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static List<String> getAccessRuleOperators() {
        List<String> retList = new ArrayList<String>();
        for (StringAccessRuleOperator oper : StringAccessRuleOperator.values()) {
            retList.add(oper.toString());
        }
        return retList;
    }

    private boolean validateStringAttributeValue(String configuredValue, String attributeValue, StringAccessRuleOperator operator) {
        switch (operator) {
            case EQUALS:
                return (configuredValue.equals(attributeValue)) ? true : false;
            case CONTAINS:
                return (configuredValue.contains(attributeValue)) ? true : false;
            case NOT_CONTAINS:
                return (!configuredValue.contains(attributeValue)) ? true : false;
            case STARTS_WITH:
                return (configuredValue.startsWith(attributeValue)) ? true : false;
            default:
                return false;
        }
    }

    public enum StringAccessRuleOperator {
        EQUALS,
        CONTAINS,
        NOT_CONTAINS,
        STARTS_WITH,
        ENDS_WITH
    }
}
