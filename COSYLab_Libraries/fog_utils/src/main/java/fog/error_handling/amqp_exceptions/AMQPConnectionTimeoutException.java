package fog.error_handling.amqp_exceptions;

import fog.error_handling.global_exceptions.ErrorCode;
import fog.error_handling.global_exceptions.UncheckedCustomProjectException;

public class AMQPConnectionTimeoutException extends UncheckedCustomProjectException {


    private final ErrorCode errorCode = ErrorCode.AMQP_TIMEOUT_ERROR;
    private String errorMessage = "AMQP connection timeout";

    public AMQPConnectionTimeoutException() {
    }

    public AMQPConnectionTimeoutException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public AMQPConnectionTimeoutException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }

    @Override
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
