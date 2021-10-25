package fog.error_handling.global_exceptions;

import fog.globals.FogComponentsConstants;

public abstract class UncheckedCustomProjectException extends RuntimeException {

	private static final long serialVersionUID = FogComponentsConstants.serialVersionUID;

	public UncheckedCustomProjectException() {
		super();
	}
	public UncheckedCustomProjectException(String message) {
		super(message);
	}

	public UncheckedCustomProjectException(Throwable cause) {
		super(cause);
	}

	public UncheckedCustomProjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public abstract ErrorCode getErrorCode();

	public abstract String getErrorMessage();
	
}
