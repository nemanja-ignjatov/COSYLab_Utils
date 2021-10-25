package fog.error_handling.custom_exceptions;

import fog.error_handling.global_exceptions.ErrorCode;
import fog.error_handling.global_exceptions.UncheckedCustomProjectException;

public class CertificateIssuanceException extends UncheckedCustomProjectException {


    private final ErrorCode errorCode = ErrorCode.CERTIFICATE_ISSUANCE_ERROR;
    private String errorMessage = "Unable to issue certificate";

    public CertificateIssuanceException() {}

    public CertificateIssuanceException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public CertificateIssuanceException(String message, Throwable cause) {
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
