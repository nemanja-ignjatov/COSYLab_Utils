package fog.payloads.faca.PDP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttributeEvaluationConfiguration {

    private String attributeName;
    private boolean isContext;
    private boolean isContextValueTimeCritical;

    public AttributeEvaluationConfiguration(String attributeName) {
        this.attributeName = attributeName;
        this.isContext = false;
        this.isContextValueTimeCritical = false;
    }
}
