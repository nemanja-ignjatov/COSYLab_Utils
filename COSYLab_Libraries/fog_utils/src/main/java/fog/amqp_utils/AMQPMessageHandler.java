package fog.amqp_utils;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fog.error_handling.amqp_exceptions.AMQPMessageParsingException;
import fog.globals.FogComponentsConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMQPMessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(AMQPMessageHandler.class);

    public static <T> T handleAMQPResponse(Object jsonBody, Class<T> responseClassType) throws AMQPMessageParsingException {
        ObjectMapper mapper = new ObjectMapper();
        if ((jsonBody != null) && (responseClassType !=null)) {
            try {
                String jsonBodyString = mapper.writeValueAsString(jsonBody);
                try {
                    Map<String, Object> respMap = mapper.readValue(jsonBodyString, LinkedHashMap.class);
                    if ((respMap.size() == FogComponentsConstants.ERR_RESP_MAP_SIZE) &&
                            ((respMap.get(FogComponentsConstants.ERR_RESP_MAP_ERR_CODE) != null) ||
                                    (respMap.get(FogComponentsConstants.ERR_RESP_MAP_ERR_MSG) != null))) {
                        logger.error("Cannot parse message {}", jsonBody);
                        throw new AMQPMessageParsingException("Cannot parse message " + jsonBody);
                    }
                } catch (JsonMappingException e) {
                    //error cant be decoded -> thats ok, means that error didnt happen
                }
                // No error received process JSON as required response
                return mapper.readValue(jsonBodyString, responseClassType);
            } catch (IOException e) {
                e.printStackTrace();
                throw new AMQPMessageParsingException("Cannot parse message " + jsonBody, e.getCause());
            }
        } else {
            return null;
        }
    }
}
