package fog.amqp_utils.routes;

public class FTARoutesConstants {

    public static final String EXCHANGE_NAME = "fta.rpc";
    public static final String FTA_QUEUE_NAME_CREATE_TICKET = "fta.rpc.create_ticket";
    public static final String FTA_QUEUE_NAME_GET_COMPONENT_CERTIFICATE = "fta.rpc.certificate.get";
    public static final String FTA_QUEUE_NAME_CERTIFICATE_VALIDATE = "fta.rpc.certificate_validation";
    public static final String FTA_QUEUE_NAME_CSR = "fta.rpc.csr";
    public static final String FTA_QUEUE_NAME_OCSP = "fta.rpc.certificate.ocsp";
}
