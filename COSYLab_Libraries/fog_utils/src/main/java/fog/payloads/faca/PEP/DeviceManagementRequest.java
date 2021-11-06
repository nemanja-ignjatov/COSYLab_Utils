package fog.payloads.faca.PEP;

import fog.faca.utils.FACAProjectConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceManagementRequest implements Serializable {

    private FACAProjectConstants.PIP_REQUEST_TYPE requestType;

}
