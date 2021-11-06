package fog.payloads.faca.PEP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceBulkAuthorizationResponse {

    private List<DeviceAuthorizationResponse> authzDevices;

}

