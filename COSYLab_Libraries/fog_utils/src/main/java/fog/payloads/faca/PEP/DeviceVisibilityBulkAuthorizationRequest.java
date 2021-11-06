package fog.payloads.faca.PEP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceVisibilityBulkAuthorizationRequest implements Serializable {

    private List<String> authzDeviceNames;

}

