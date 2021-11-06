package fog.payloads.faca.PEP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceAuthorizationResponse {

    private String deviceName;
    private String functionName;
    private boolean accessGranted;

}

