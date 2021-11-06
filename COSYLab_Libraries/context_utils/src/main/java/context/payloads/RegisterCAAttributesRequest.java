package context.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class RegisterCAAttributesRequest implements Serializable {

    private List<ContextAttributeConfiguration> attributes;

    public RegisterCAAttributesRequest(ContextAttributeConfiguration attribute) {
        this.attributes = List.of(attribute);
    }

}
