package context.payloads;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@NoArgsConstructor
@Data
public class AttributeValueEvaluationRequestItem implements Serializable {

    private String attributeName;
    private String deviceId;
    private String functionName;
    private String userId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp;

    public AttributeValueEvaluationRequestItem(String attributeName, String deviceId, String functionName, String userId) {
        this.attributeName = attributeName;
        this.deviceId = deviceId;
        this.functionName = functionName;
        this.userId = userId;
        this.timestamp = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
    }

}
