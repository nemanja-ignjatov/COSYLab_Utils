package fog.payloads.faca.PAP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeletePolicyRequest implements Serializable {

    private String policyId;

}
