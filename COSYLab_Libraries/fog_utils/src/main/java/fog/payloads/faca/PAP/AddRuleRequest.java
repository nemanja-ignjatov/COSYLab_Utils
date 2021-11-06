package fog.payloads.faca.PAP;

import fog.faca.access_rules.IAccessRule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddRuleRequest implements Serializable {


    private String deviceName;
    private String functionName;
    private String cloudDeviceTypeId;
    private String deviceTypeName;

    private IAccessRule rule;

}
