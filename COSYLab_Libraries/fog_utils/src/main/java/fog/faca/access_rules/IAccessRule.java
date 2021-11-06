package fog.faca.access_rules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fog.payloads.faca.PDP.AttributeEvaluationConfiguration;
import fog.payloads.faca.PDP.AttributeValueWrapper;

import java.util.List;
import java.util.Map;

@JsonDeserialize(using = AccessRuleJSONDeserializer.class)
public interface IAccessRule {

    boolean isValidAgainstAttributes(Map<String, AttributeValueWrapper> userAttrs);

    AccessRuleType getType();

    String convertToJSON() throws JsonProcessingException;

    List<AttributeEvaluationConfiguration> getAttributeEvaluationInfo();

    void updateAttributeNames(String currentAttributeName, String newAttributeName);
}
