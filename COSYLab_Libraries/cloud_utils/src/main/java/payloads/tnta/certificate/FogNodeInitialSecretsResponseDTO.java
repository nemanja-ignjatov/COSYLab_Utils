package payloads.tnta.certificate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FogNodeInitialSecretsResponseDTO {

    private String id;
    private String applicationSecret;
    private String instanceSecret;

}
