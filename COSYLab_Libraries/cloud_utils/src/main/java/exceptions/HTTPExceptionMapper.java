package exceptions;

import exceptions.RootExceptions.CustomProjectException;
import exceptions.RootExceptions.ErrorHTTPResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import utils.CloudConstants;

public class HTTPExceptionMapper {

    public static ResponseEntity<ErrorHTTPResponse> convertExceptionToHttpError(Exception e) {
        if (e instanceof CustomProjectException) {
            CustomProjectException cpe = (CustomProjectException) e;
            return new ResponseEntity<ErrorHTTPResponse>(
                    new ErrorHTTPResponse(cpe.getErrorMessage(), cpe.getStatusCode().ordinal()), cpe.getStatusCode());
        } else {
            e.printStackTrace();
            return new ResponseEntity<ErrorHTTPResponse>(new ErrorHTTPResponse(CloudConstants.ERR_INTERNAL_SRV_MSG,
                    HttpStatus.INTERNAL_SERVER_ERROR.ordinal()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
