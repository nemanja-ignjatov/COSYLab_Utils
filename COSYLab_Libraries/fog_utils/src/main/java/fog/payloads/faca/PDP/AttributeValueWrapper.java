package fog.payloads.faca.PDP;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AttributeValueWrapper {

    private String value;
    private double certainty;
    private Boolean authzDecision;

    public AttributeValueWrapper(String value) {
        this.value = value;
        this.certainty = 100;
        this.authzDecision = null;
    }

    public AttributeValueWrapper(String value, double certainty) {
        this.value = value;
        this.certainty = certainty;
        this.authzDecision = null;
    }


    public AttributeValueWrapper(boolean authzDecision) {
        this.authzDecision = authzDecision;
    }

    public Boolean isAuthzDecision() {
        return authzDecision;
    }
}
