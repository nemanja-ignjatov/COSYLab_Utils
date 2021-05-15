package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class ServiceNameNotFoundException extends CustomProjectException {

    private final HttpStatus statusCode = HttpStatus.NOT_FOUND;
    private final static String errorMessage = "Service name unknown to Server";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
