package context.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class UpdateCAAttributesRequest implements Serializable {

    private List<ContextAttributeConfiguration> createAttributes;
    private List<String> deleteAttributes;
    private List<UpdateContextAttributeName> updateAttributes;

}
