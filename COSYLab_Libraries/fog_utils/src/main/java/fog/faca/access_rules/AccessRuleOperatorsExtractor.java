package fog.faca.access_rules;

import fog.faca.access_rules.rule_types.BooleanAccessRule;
import fog.faca.access_rules.rule_types.CompositeAccessRule;
import fog.faca.access_rules.rule_types.NumericAccessRule;
import fog.faca.access_rules.rule_types.StringAccessRule;

import java.util.ArrayList;
import java.util.List;

public class AccessRuleOperatorsExtractor {

    public static List<String> getOperatorsForAccessRuleType(AccessRuleType accessRuleType) {
        switch (accessRuleType) {
            case COMPOSITE:
                return CompositeAccessRule.getAccessRuleOperators();
            case NUMERIC:
                return NumericAccessRule.getAccessRuleOperators();
            case STRING:
                return StringAccessRule.getAccessRuleOperators();
            case BOOLEAN:
                return BooleanAccessRule.getAccessRuleOperators();
            default:
                return new ArrayList<String>();
        }
    }
}
