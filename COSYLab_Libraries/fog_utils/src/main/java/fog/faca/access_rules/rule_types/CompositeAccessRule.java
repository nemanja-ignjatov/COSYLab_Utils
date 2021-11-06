package fog.faca.access_rules.rule_types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fog.faca.access_rules.AccessRuleType;
import fog.faca.access_rules.IAccessRule;
import fog.payloads.faca.PDP.AttributeEvaluationConfiguration;
import fog.payloads.faca.PDP.AttributeValueWrapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.util.*;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class CompositeAccessRule implements IAccessRule {

    private AccessRuleType type = AccessRuleType.COMPOSITE;
    private Set<IAccessRule> accessRules;
    private CompositeAccessRulesOperator operator;

    public CompositeAccessRule(Set<IAccessRule> accessRules, CompositeAccessRulesOperator operator) {
        this.accessRules = accessRules;
        this.operator = operator;
    }

    public CompositeAccessRule(JsonNode jsonNode) throws IOException {

        this.operator = CompositeAccessRulesOperator.valueOf(jsonNode.get("operator").asText());
        JsonNode rulesJsonNode = jsonNode.get("accessRules");
        if ((rulesJsonNode != null) && !rulesJsonNode.isNull()) {
            this.accessRules = new HashSet<>();
            for (final JsonNode ruleNode : rulesJsonNode) {
                AccessRuleType ruleType = AccessRuleType.valueOf(ruleNode.get("accessRuleType").asText());
                switch (ruleType) {
                    case BOOLEAN:
                        this.accessRules.add(new BooleanAccessRule(ruleNode));
                        break;
                    case NUMERIC:
                        this.accessRules.add(new NumericAccessRule(ruleNode));
                        break;
                    case STRING:
                        this.accessRules.add(new StringAccessRule(ruleNode));
                        break;
                    case COMPOSITE:
                        this.accessRules.add(new CompositeAccessRule(ruleNode));
                        break;
                    case CONTEXT:
                        this.accessRules.add(new ContextAccessRule(ruleNode));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public boolean isValidAgainstAttributes(Map<String, AttributeValueWrapper> userAttrs) {
        switch (this.operator) {
            case AND:
                return validateCompositeRuleAndOperator(userAttrs);
            case OR:
                return validateCompositeRuleOrOperator(userAttrs);
            default:
                return false;
        }
    }

    @Override
    public String convertToJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public List<AttributeEvaluationConfiguration> getAttributeEvaluationInfo() {
        List<AttributeEvaluationConfiguration> retList = new ArrayList<>();
        for (IAccessRule accessRule : this.accessRules) {
            retList.addAll(accessRule.getAttributeEvaluationInfo());
        }
        return retList;
    }

    @Override
    public void updateAttributeNames(String currentAttributeName, String newAttributeName) {
        for (IAccessRule accessRule : this.accessRules) {
            accessRule.updateAttributeNames(currentAttributeName,newAttributeName);
        }
    }

    public static List<String> getAccessRuleOperators() {
        List<String> retList = new ArrayList<String>();
        for (CompositeAccessRulesOperator oper : CompositeAccessRulesOperator.values()) {
            retList.add(oper.toString());
        }
        return retList;
    }

    private boolean validateCompositeRuleAndOperator(Map<String, AttributeValueWrapper> userAttrs) {
        if (this.accessRules != null) {
            int validAccessRules = 0;
            for (IAccessRule accessRule : this.accessRules) {
                boolean isValid = accessRule.isValidAgainstAttributes(userAttrs);
                if (isValid) {
                    validAccessRules++;
                }
            }
            return (validAccessRules >= this.accessRules.size()) ? true : false;
        }
        //no access rules -> allow access
        return false;
    }

    private boolean validateCompositeRuleOrOperator(Map<String, AttributeValueWrapper> userAttrs) {
        if (this.accessRules != null) {
            for (IAccessRule accessRule : this.accessRules) {
                if (accessRule.isValidAgainstAttributes(userAttrs)) {
                    return true;
                }
            }
        }
        return false;

    }

    public enum CompositeAccessRulesOperator {
        AND,
        OR
    }
}
