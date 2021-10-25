package fog.payloads.fta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FogComponentCertificateData {

    private String identity;
    private String certificateContent;
    private boolean isValid;
}
