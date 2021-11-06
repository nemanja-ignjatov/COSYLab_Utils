package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateRoleRequest implements Serializable {

    private String id;
    private String role;

}
