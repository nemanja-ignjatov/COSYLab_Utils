package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class TicketValidationException extends CustomProjectException {


    private final HttpStatus statusCode = HttpStatus.CONFLICT;
    private final static String errorMessage = "Provided ticket not valid.";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
