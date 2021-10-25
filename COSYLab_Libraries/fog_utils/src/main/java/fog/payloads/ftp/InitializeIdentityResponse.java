package fog.payloads.ftp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InitializeIdentityResponse implements Serializable {

    private String generatedId;
    private ThingSecurityProfile securityProfile;
    private String ftpCertificate;
    
}
