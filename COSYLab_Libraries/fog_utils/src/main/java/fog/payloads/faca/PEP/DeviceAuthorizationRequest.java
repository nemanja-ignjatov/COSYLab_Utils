package fog.payloads.faca.PEP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceAuthorizationRequest implements Serializable {

    private String deviceName;
    private String functionName;

}

