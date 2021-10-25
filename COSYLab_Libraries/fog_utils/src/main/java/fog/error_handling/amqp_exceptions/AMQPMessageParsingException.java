package fog.error_handling.amqp_exceptions;

import fog.error_handling.global_exceptions.ErrorCode;
import fog.error_handling.global_exceptions.UncheckedCustomProjectException;

public class AMQPMessageParsingException extends UncheckedCustomProjectException {


    private final ErrorCode errorCode = ErrorCode.AMQP_PARSING_ERROR;
    private String errorMessage = "Unable to parse AMQP message";

    public AMQPMessageParsingException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public AMQPMessageParsingException(String message, Throwable cause) {
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
