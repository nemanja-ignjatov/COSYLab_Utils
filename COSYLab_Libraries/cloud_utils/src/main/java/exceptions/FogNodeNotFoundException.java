package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class FogNodeNotFoundException extends CustomProjectException {

    private final HttpStatus statusCode = HttpStatus.NOT_FOUND;
    private final static String errorMessage = "Fog Node was not found in database";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
