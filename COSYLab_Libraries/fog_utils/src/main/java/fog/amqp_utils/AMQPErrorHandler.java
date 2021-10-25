package fog.amqp_utils;

import fog.amqp_utils.payloads.AMQPResponseEntity;
import fog.error_handling.global_exceptions.CustomProjectException;
import fog.globals.FogComponentsConstants;
import fog.http_utils.ErrorHTTPResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class AMQPErrorHandler {

    public static AMQPResponseEntity<ErrorHTTPResponse> convertExceptionToAMQP(Exception e) {
        if (e instanceof CustomProjectException) {
            log.error("CustomProjectException occured: " + e.getMessage());
            e.printStackTrace();
            CustomProjectException cpe = (CustomProjectException) e;
            return new AMQPResponseEntity<ErrorHTTPResponse>(
                    new ErrorHTTPResponse(cpe.getErrorMessage(), cpe.getErrorCode().ordinal()), HttpStatus.OK.value());
        } else {
            log.error("Critical unhandled exception occured: " + e.getMessage());
            e.printStackTrace();
            return new AMQPResponseEntity<ErrorHTTPResponse>(new ErrorHTTPResponse(FogComponentsConstants.ERR_INTERNAL_SRV_MSG,
                    HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
