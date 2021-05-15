package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class BadRequestBodyException extends CustomProjectException {


    private final HttpStatus statusCode = HttpStatus.BAD_REQUEST;
    private final static String errorMessage = "One of the values in the request is wrong!";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
