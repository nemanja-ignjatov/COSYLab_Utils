package fog.faca.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JSONUtilFunctions {

    public static String convertListStringToJSON(List<String> stringList) {
        if (stringList != null) {
            ObjectMapper objMapper = new ObjectMapper();
            try {
                return objMapper.writeValueAsString(stringList);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
        return null;
    }
}
