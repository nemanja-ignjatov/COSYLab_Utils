package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectManagementConfiguration {

    private HashMap<String, Integer> rolesConfiguration;

}
