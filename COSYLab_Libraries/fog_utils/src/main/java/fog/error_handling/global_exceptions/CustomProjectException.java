package fog.error_handling.global_exceptions;

import fog.globals.FogComponentsConstants;

public abstract class CustomProjectException extends Exception {
	
	private static final long serialVersionUID = FogComponentsConstants.serialVersionUID;

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

	public abstract ErrorCode getErrorCode();

	public abstract String getErrorMessage();
	
}
