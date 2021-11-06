package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import payloads.acam.deviceTypes.DeviceTypeDTO;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateDeviceTypesRequest {

    private List<DeviceTypeDTO> deviceTypes;

}
