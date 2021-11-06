package fog.payloads.faca.PAP;

import fog.faca.access_rules.IAccessRule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PolicyDTO {

    private String id;

    private String deviceName;
    private String function;
    private IAccessRule rule;
    private int priority;

    private String cloudDeviceTypeId;
    private String deviceTypeName;

    private boolean enabled;

    public PolicyDTO(String deviceName, IAccessRule rule, int priority, boolean enabled) {
        this.deviceName = deviceName;
        this.rule = rule;
        this.priority = priority;
        this.enabled = enabled;
    }

}
