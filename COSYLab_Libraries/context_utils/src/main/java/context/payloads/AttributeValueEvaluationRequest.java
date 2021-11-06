package context.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttributeValueEvaluationRequest implements Serializable {

    private List<AttributeValueEvaluationRequestItem> requests;

}
