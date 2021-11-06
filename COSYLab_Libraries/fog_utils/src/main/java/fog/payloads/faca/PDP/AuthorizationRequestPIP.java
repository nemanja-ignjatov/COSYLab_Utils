package fog.payloads.faca.PDP;

import fog.faca.utils.FACAProjectConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorizationRequestPIP {

	private FACAProjectConstants.PIP_REQUEST_TYPE requestType;

	private String targetSubjectUserName;


	public AuthorizationRequestPIP(FACAProjectConstants.PIP_REQUEST_TYPE requestType) {
		this.requestType = requestType;
	}

}
