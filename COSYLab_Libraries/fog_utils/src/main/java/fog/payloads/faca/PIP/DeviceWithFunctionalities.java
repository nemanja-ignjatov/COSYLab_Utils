package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceWithFunctionalities {

    private String id;
    private String name;
    private String symbolicName;
    private String deviceType;
    private List<String> functionalities;

}
