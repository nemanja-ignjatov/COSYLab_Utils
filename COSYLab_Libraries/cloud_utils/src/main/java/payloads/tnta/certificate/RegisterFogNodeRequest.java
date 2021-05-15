package payloads.tnta.certificate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterFogNodeRequest {

    private String hashFogInitialCredentials;
    private String hashFogNodeSecret;
    private String identity;

}
