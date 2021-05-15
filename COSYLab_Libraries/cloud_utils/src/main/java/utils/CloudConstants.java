package utils;

public class CloudConstants {

    public static final long serialVersionUID = 7526472295622776147L;

    public static final String HEADER_NAME_SET_TOKEN = "Set-Authorization";
    public static final String HEADER_NAME_TOKEN = "Authorization";


    public static final String FUNCTIONALITY_VIEW_DEVICE = "viewDevice" ;
    public static final String HOMEASSISTANT_SERVICE_NAME = "HomeAssistant" ;

    public enum Role {
        DEFAULT, OWNER, GOD
    }

    public static final String TOKEN_CACHE_NAME = "sessionCache";

    public static final String ERR_INTERNAL_SRV_MSG = "Internal Server Error. Please notify an administrator" ;

    public static final String HEADER_TICKET_TOKEN = "Ticket-Token";
    public static final String HEADER_TICKET_ISSUER = "Ticket-Issuer";
    public static final String HEADER_REQUEST_SENDER = "Request-Sender";

    public static final String REVOCATION_LIST_URI = "/certificate/list/revoked";

    public static final String APP_NAME_TNTA = "tnta";
    public static final String APP_NAME_ACAM = "acam";

    public static final String ACAM_ROUTE_VALIDATE_SESSION = "/acam/auth/validate";
    public static final String ACAM_GET_DEVICE_TYPES_VERSION = "/acam/devicetype/listLatestDeviceTypeVersions";
    public static final String ACAM_LIST_DEVICE_CHANGES = "/acam/devicetype/listChangeUpdates";
    public static final String TNTA_ROUTE_VALIDATE_TICKET = "/tnta/cloud/ticket/validate";
    public static final String TNTA_ROUTE_CREATE_TICKET = "/tnta/cloud/ticket/sign";

    public static final String TNTA_ROUTE_REGISTER_FTA = "/tnta/fog/register";
    public static final String TNTA_ROUTE_FTA_CSR = "/tnta/fog/certificate/issue";

    public static final String TICKET_FIELD_FUNCTIONALITY = "functionality";
    public static final String TICKET_FIELD_MESSAGE_HASH = "messageHash";
    public static final String TICKET_FIELD_TYPE = "ticketType";
}
