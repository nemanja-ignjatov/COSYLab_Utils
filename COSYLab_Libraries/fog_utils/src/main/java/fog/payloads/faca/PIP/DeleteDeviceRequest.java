package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteDeviceRequest {

    private String deviceId;

}
