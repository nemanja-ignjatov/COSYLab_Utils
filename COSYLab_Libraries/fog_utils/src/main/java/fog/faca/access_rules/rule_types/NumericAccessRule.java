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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class NumericAccessRule implements ISimpleAccessRule {

    private AccessRuleType type = AccessRuleType.NUMERIC;
    private Number expectedValue;
    private String attributeName;
    private NumericAccessRuleOperator operator;

    public NumericAccessRule(Number expectedValue, String attributeName, NumericAccessRuleOperator operator) {
        this.expectedValue = expectedValue;
        this.attributeName = attributeName;
        this.operator = operator;
    }

    public NumericAccessRule(JsonNode node) {
        this.expectedValue = node.get("expectedValue").asDouble();
        this.attributeName = node.get("attributeName").asText();
        this.operator = NumericAccessRuleOperator.valueOf(node.get("operator").asText());
    }

    @Override
    public boolean isValidAgainstAttributes(Map<String, AttributeValueWrapper> userAttrs) {
        AttributeValueWrapper controllerValueWrapper = userAttrs.get(attributeName);
        if(controllerValueWrapper == null) {
            return false;
        }
        String controlledVal = controllerValueWrapper.getValue();
        BigDecimal tokenAttributeVal = new BigDecimal(controlledVal);
        BigDecimal accessRuleVal = new BigDecimal(this.expectedValue.toString());
        if ((accessRuleVal != null) && (tokenAttributeVal != null) &&
                validateNumberAttributeValue(accessRuleVal, tokenAttributeVal, this.operator)) {
            return true;
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
        for (NumericAccessRuleOperator oper : NumericAccessRuleOperator.values()) {
            retList.add(oper.toString());
        }
        return retList;
    }

    private boolean validateNumberAttributeValue(BigDecimal configuredValue, BigDecimal attributeValue, NumericAccessRuleOperator operator) {
        switch (operator) {
            case EQUALS:
                return (attributeValue.compareTo(configuredValue) == 0) ? true : false;
            case GREATER_OR_EQUAL_THAN:
                return (attributeValue.compareTo(configuredValue) >= 0) ? true : false;
            case GREATER_THAN:
                return (attributeValue.compareTo(configuredValue) > 0) ? true : false;
            case LESS_OR_EQUALS_THAN:
                return (attributeValue.compareTo(configuredValue) <= 0) ? true : false;
            case LESS_THAN:
                return (attributeValue.compareTo(configuredValue) < 0) ? true : false;
            case NOT_EQUALS:
                return (attributeValue.compareTo(configuredValue) != 0) ? true : false;
            default:
                return false;
        }
    }

    public enum NumericAccessRuleOperator {
        EQUALS,
        NOT_EQUALS,
        GREATER_THAN,
        GREATER_OR_EQUAL_THAN,
        LESS_THAN,
        LESS_OR_EQUALS_THAN
    }



}
