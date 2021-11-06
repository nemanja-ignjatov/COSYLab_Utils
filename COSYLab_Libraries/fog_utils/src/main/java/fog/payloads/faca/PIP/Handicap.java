package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Handicap implements Serializable {

    private String handicap;

}
