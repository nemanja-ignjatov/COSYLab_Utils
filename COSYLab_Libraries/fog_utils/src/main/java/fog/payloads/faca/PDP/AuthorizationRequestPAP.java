package fog.payloads.faca.PDP;

import fog.faca.utils.FACAProjectConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorizationRequestPAP {

    private FACAProjectConstants.PAP_REQUEST_TYPE requestType;

}
