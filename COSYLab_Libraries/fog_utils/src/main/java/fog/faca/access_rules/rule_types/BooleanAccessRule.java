package fog.faca.access_rules.rule_types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fog.faca.utils.FACAProjectConstants;
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
import java.util.Objects;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class BooleanAccessRule implements ISimpleAccessRule {

    private String attributeName;
    private BooleanRelationalOperator operator;
    private AccessRuleType type = AccessRuleType.BOOLEAN;

    public BooleanAccessRule(String attributeName, BooleanRelationalOperator operator) {
        this.attributeName = attributeName;
        this.operator = operator;
    }

    public BooleanAccessRule(JsonNode node) {
        this.attributeName = node.get("attributeName").asText();
        this.operator = BooleanRelationalOperator.valueOf(node.get("operator").asText());
    }


    @Override
    public boolean isValidAgainstAttributes(Map<String, AttributeValueWrapper> userAttrs) {

        AttributeValueWrapper controllerValueWrapper = userAttrs.get(attributeName);
        if(controllerValueWrapper == null) {
            return false;
        }
        String controlledValueString = controllerValueWrapper.getValue();
        //Evaluate attribute value against operator
        if (controlledValueString != null) {
            switch (this.operator) {
                case TRUE:
                    if (controlledValueString.toLowerCase().equals(FACAProjectConstants.BOOLEAN_STRING_VALUE_TRUE)) {
                        return true;
                    }
                    break;
                case FALSE:
                    if (controlledValueString.toLowerCase().equals(FACAProjectConstants.BOOLEAN_STRING_VALUE_FALSE)) {
                        return true;
                    }
                    break;
                default:
            }
        }
        return false;
    }

    @Override
    public String convertToJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
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

    public static List<String> getAccessRuleOperators() {
        List<String> retList = new ArrayList<String>();
        for (BooleanRelationalOperator oper : BooleanRelationalOperator.values()) {
            retList.add(oper.toString());
        }
        return retList;
    }

    public enum BooleanRelationalOperator {
        TRUE,
        FALSE,
    }

}
