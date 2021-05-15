package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class KeyStoreHandlingException extends CustomProjectException {


    private final HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    private final static String errorMessage = "Unable to handle keystore operation";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
