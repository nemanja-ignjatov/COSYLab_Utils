package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateDeviceRequest {

    private String deviceId;
    private String deviceTypeId;
    private String symbolicName;

}
