package fog.payloads.ftp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterThingRequest implements Serializable {

    private String generatedId;

}
