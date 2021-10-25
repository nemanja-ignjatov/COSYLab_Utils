package fog.error_handling.global_exceptions;

public enum ErrorCode {
    INTERNAL_ERROR,
    AMQP_PARSING_ERROR,
    AMQP_TIMEOUT_ERROR,

    THING_MISSING_KEY_ERROR,
    CERTIFICATE_ISSUANCE_ERROR
}
