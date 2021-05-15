package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import org.springframework.http.HttpStatus;

public class DeviceTypeNotFoundException  extends CustomProjectException {


    private final HttpStatus statusCode = HttpStatus.NOT_FOUND;
    private final static String errorMessage = "Device Type was not found in DataBase";

    @Override
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
