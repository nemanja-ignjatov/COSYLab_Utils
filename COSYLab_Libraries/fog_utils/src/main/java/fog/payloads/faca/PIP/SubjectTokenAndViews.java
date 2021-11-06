package fog.payloads.faca.PIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectTokenAndViews {

    private SubjectSecured subject;
    private List<String> allowedViews;
    private String token;

}
