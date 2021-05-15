package payloads.tnta.certificate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FogNodeCSRResponse {

    private String certificateContent;

}
