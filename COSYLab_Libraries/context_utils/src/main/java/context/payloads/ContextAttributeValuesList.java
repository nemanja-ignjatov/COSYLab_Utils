package context.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContextAttributeValuesList {

    private List<AttributeValueChangeNotification> attributeValues;

}
