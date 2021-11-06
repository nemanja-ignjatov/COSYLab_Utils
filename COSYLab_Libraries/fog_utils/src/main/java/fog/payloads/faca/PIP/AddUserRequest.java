package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddUserRequest implements Serializable {

    private String userName;

    private String password;
    private String name;
    private Date birthdate;

}
