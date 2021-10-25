package fog.error_handling.global_exceptions;

public class InternalServerErrorException extends CustomProjectException {


    private final ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
    private final static String errorMessage = "Internal Error. If problem persists, please contact an administrator";

    @Override
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
