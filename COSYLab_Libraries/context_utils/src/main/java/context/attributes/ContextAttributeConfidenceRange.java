package context.attributes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContextAttributeConfidenceRange implements Serializable {

    private float minimum;
    private float maximum;

}
