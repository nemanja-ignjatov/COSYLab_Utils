package fog.payloads.faca.PDP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorizationResponse {

	private String message;
	private boolean accepted;

}
