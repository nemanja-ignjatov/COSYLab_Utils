package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class DeviceTypeCRUDConflictException extends CustomProjectException {

    private final HttpStatus statusCode = HttpStatus.CONFLICT;
    private final static String errorMessage = "Conflict while adding new DeviceType to Database (already Exists)";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
