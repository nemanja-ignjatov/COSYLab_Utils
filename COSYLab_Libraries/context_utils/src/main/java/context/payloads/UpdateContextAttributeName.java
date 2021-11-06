package context.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateContextAttributeName implements Serializable {

    private String oldAttributeName;
    private String newAttributeName;

}
