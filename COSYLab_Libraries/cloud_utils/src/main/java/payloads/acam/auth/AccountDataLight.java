package payloads.acam.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.CloudConstants;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDataLight {
    private String accountName;
    private CloudConstants.Role accountRole;
}
