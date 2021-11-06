package fog.payloads.faca.PDP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthCode {

    private String authCode;
    private String tokenString;
    private long created;

}
