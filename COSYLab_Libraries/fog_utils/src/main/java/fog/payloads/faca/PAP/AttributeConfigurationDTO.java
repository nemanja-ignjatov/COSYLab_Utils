package fog.payloads.faca.PAP;

import fog.faca.access_rules.AccessRuleType;
import fog.faca.utils.AttributeConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AttributeConfigurationDTO {

    private String id;
    private String name;
    private AccessRuleType accessRuleType;
    private AttributeConstraint constraint;
    private List<String> operators;
    private String contextType;
    private List<String> contextOperators;
    private boolean timeCriticalContextValueAllowed;

    public AttributeConfigurationDTO(String id, String name, AccessRuleType accessRuleType, AttributeConstraint constraint, List<String> operators) {
        this.id = id;
        this.name = name;
        this.accessRuleType = accessRuleType;
        this.constraint = constraint;
        this.operators = operators;
    }
}
