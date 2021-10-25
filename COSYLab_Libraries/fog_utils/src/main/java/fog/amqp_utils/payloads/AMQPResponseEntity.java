package fog.amqp_utils.payloads;

public class AMQPResponseEntity<T> {

    private T message;
    private int statusCode;
    private String setAuthorizationToken;

    public AMQPResponseEntity() {
    }

    public AMQPResponseEntity(T message) {
        this.message = message;
    }

    public AMQPResponseEntity(T message, int statusCode, String setAuthorizationToken) {
        this.message = message;
        this.statusCode = statusCode;
        this.setAuthorizationToken = setAuthorizationToken;
    }

    public AMQPResponseEntity(T message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getSetAuthorizationToken() {
        return setAuthorizationToken;
    }

    public void setSetAuthorizationToken(String setAuthorizationToken) {
        this.setAuthorizationToken = setAuthorizationToken;
    }

    @Override
    public String toString() {
        return "AMQPResponseEntity{" +
                "message=" + message +
                ", statusCode=" + statusCode +
                ", setAuthorizationToken='" + setAuthorizationToken + '\'' +
                '}';
    }
}
