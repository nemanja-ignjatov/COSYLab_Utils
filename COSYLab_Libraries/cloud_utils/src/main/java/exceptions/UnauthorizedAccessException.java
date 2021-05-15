package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class UnauthorizedAccessException extends CustomProjectException {

    private final HttpStatus statusCode = HttpStatus.UNAUTHORIZED;
    private final static String errorMessage = "Unauthorized access!";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
