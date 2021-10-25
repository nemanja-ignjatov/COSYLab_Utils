package fog.payloads.ftp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitializeIdentityRequest implements Serializable {

    private String id;
    private ThingSecurityProfile securityProfile;
    private String deviceType;
    private String encryptionAlgorithm;
}
