package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class FogNodeCRUDConflictException extends CustomProjectException {


    private final HttpStatus statusCode = HttpStatus.CONFLICT;
    private final static String errorMessage = "Conflict while editing Fog Node in Database";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
