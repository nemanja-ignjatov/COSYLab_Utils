package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class SecurityMisconfigurationException extends CustomProjectException {


    private final HttpStatus statusCode = HttpStatus.BAD_REQUEST;
    private final static String errorMessage = "Security settings not configured property";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
