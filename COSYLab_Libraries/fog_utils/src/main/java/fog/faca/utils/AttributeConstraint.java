package fog.faca.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttributeConstraint {

    public Integer minValue;
    public Integer maxValue;
    public List<String> allowedValues;

    public AttributeConstraint(Integer minValue, Integer maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public AttributeConstraint(List<String> allowedValues) {
        this.allowedValues = allowedValues;
    }

}
