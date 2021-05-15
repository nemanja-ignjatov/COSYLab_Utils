package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends CustomProjectException {

    private final HttpStatus statusCode = HttpStatus.UNAUTHORIZED;
    private final static String errorMessage = "Invalid username oder password";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
