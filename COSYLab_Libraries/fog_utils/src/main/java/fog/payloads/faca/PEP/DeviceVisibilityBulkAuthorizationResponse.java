package fog.payloads.faca.PEP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceVisibilityBulkAuthorizationResponse {

    private List<String> visibleDeviceNames;

}

