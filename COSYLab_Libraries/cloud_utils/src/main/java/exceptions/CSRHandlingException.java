package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class CSRHandlingException extends CustomProjectException {


    private final HttpStatus statusCode = HttpStatus.BAD_REQUEST;
    private final static String errorMessage = "Unable to handle CSR";

    public CSRHandlingException(String message) {
        super(message);
    }

    public CSRHandlingException(Throwable cause) {
        super(cause);
    }

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
