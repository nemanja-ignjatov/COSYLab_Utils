package fog.payloads.fta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FogComponentCSR implements Serializable {

    private String identity;
    private String csrContent;

}
