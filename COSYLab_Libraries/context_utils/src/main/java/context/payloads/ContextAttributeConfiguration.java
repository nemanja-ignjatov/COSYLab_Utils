package context.payloads;

import context.attributes.ContextAttributeConfidenceRange;
import context.attributes.ContextDistributionPattern;
import context.attributes.ContextType;
import fog.faca.access_rules.AccessRuleType;
import fog.faca.utils.AttributeConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ContextAttributeConfiguration implements Serializable {

    private String attributeName;
    private ContextType contextType;
    private AccessRuleType accessRuleType;
    private AttributeConstraint constraint;
    private ContextDistributionPattern distributionPattern;
    private Integer valueMaximumTimePeriodSeconds;
    private Long attributeValueValiditySeconds;
    private ContextAttributeConfidenceRange certaintyRange;
    private String attributeValueEvaluationRoute;


    public ContextAttributeConfiguration(ContextAttributeConfiguration contextAttributeConfiguration) {
        this.attributeName = contextAttributeConfiguration.attributeName;
        this.contextType = contextAttributeConfiguration.contextType;
        this.accessRuleType = contextAttributeConfiguration.accessRuleType;
        this.constraint = contextAttributeConfiguration.constraint;
        this.distributionPattern = contextAttributeConfiguration.distributionPattern;
        this.valueMaximumTimePeriodSeconds = contextAttributeConfiguration.valueMaximumTimePeriodSeconds;
        this.attributeValueValiditySeconds = contextAttributeConfiguration.attributeValueValiditySeconds;
        this.certaintyRange = contextAttributeConfiguration.certaintyRange;
        this.attributeValueEvaluationRoute = contextAttributeConfiguration.attributeValueEvaluationRoute;
    }

    public ContextAttributeConfiguration(String attributeName, ContextType contextType, AccessRuleType accessRuleType, AttributeConstraint constraint, ContextDistributionPattern distributionPattern, Integer valueMaximumTimePeriodSeconds, Long attributeValueValiditySeconds, ContextAttributeConfidenceRange certaintyRange) {
        this.attributeName = attributeName;
        this.contextType = contextType;
        this.accessRuleType = accessRuleType;
        this.constraint = constraint;
        this.distributionPattern = distributionPattern;
        this.valueMaximumTimePeriodSeconds = valueMaximumTimePeriodSeconds;
        this.attributeValueValiditySeconds = attributeValueValiditySeconds;
        this.certaintyRange = certaintyRange;
    }

    public ContextAttributeConfiguration(String attributeName, ContextType contextType, AccessRuleType accessRuleType, AttributeConstraint constraint, ContextDistributionPattern distributionPattern, Integer valueMaximumTimePeriodSeconds, Long attributeValueValiditySeconds, ContextAttributeConfidenceRange certaintyRange,
                                         String attributeValueEvaluationRoute) {
        this.attributeName = attributeName;
        this.contextType = contextType;
        this.accessRuleType = accessRuleType;
        this.constraint = constraint;
        this.distributionPattern = distributionPattern;
        this.valueMaximumTimePeriodSeconds = valueMaximumTimePeriodSeconds;
        this.attributeValueValiditySeconds = attributeValueValiditySeconds;
        this.certaintyRange = certaintyRange;
        this.attributeValueEvaluationRoute = attributeValueEvaluationRoute;
    }

}
