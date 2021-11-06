package context.payloads;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import context.attributes.ContextType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@NoArgsConstructor
@Data
public class AttributeValueChangeNotification implements Serializable {

    private String attributeName;
    private String attributeValue;
    private double certainty;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp;

    private ContextType contextType;

    public AttributeValueChangeNotification(AttributeValueChangeNotification attributeValueChangeNotification) {
        this.attributeName = attributeValueChangeNotification.attributeName;
        this.attributeValue = attributeValueChangeNotification.attributeValue;
        this.certainty = attributeValueChangeNotification.certainty;
        this.timestamp = attributeValueChangeNotification.timestamp;
        this.contextType = attributeValueChangeNotification.contextType;
    }
    public AttributeValueChangeNotification(String attributeName, String attributeValue, double certainty, ContextType contextType) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.certainty = certainty;
        this.timestamp = LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault());
        this.contextType = contextType;
    }
}
