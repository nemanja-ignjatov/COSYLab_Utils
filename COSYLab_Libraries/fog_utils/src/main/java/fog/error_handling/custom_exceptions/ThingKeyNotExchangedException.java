package fog.error_handling.custom_exceptions;

import fog.error_handling.global_exceptions.ErrorCode;
import fog.error_handling.global_exceptions.UncheckedCustomProjectException;

public class ThingKeyNotExchangedException extends UncheckedCustomProjectException {


    private final ErrorCode errorCode = ErrorCode.THING_MISSING_KEY_ERROR;
    private String errorMessage = "Thing security is not exchanged";

    public ThingKeyNotExchangedException() {}

    public ThingKeyNotExchangedException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public ThingKeyNotExchangedException(String message, Throwable cause) {
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
