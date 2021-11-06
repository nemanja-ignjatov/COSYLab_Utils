package fog.faca.access_rules;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import fog.faca.utils.FACAProjectConstants;
import fog.faca.access_rules.rule_types.*;

import java.io.IOException;

public class AccessRuleJSONDeserializer extends JsonDeserializer<IAccessRule> {

    @Override
    public IAccessRule deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        IAccessRule rule = null;
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        //Read type of access policy in JSON
        JsonNode policyType = node.get(FACAProjectConstants.ACCESS_POLICY_JSON_FIELD_TYPE);
        //Invoke required deserializer from IAccessPolicy specifier
        AccessRuleType apType = AccessRuleType.valueOf(policyType.asText());
        switch (apType) {
            case COMPOSITE:
                rule = new CompositeAccessRule(node);
                break;
            case STRING:
                rule = new StringAccessRule(node);
                break;
            case NUMERIC:
                rule = new NumericAccessRule(node);
                break;
            case BOOLEAN:
                rule = new BooleanAccessRule(node);
                break;
            case CONTEXT:
                rule = new ContextAccessRule(node);
                break;
            default:
                throw new IOException();

        }

        return rule;

    }
}
