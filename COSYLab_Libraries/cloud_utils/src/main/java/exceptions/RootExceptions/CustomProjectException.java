package exceptions.RootExceptions;

import org.springframework.http.HttpStatus;

public abstract class CustomProjectException extends Exception {


    public CustomProjectException() {
        super();
    }

    public CustomProjectException(String message) {
        super(message);
    }

    public CustomProjectException(Throwable cause) {
        super(cause);
    }

    public CustomProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatusCode();

    public abstract String getErrorMessage();
}
