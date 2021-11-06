package fog.payloads.faca.PEP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class DeviceBulkAuthorizationRequest implements Serializable {

    private List<DeviceAuthorizationRequest> authzDevices;

    public DeviceBulkAuthorizationRequest() {
        this.authzDevices = new ArrayList<>();
    }

}

