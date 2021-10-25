package fog.payloads.fta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateValidationHolder {

    private String certificate;
    private String ticketToken;
    private String ticketIssuer;

}
