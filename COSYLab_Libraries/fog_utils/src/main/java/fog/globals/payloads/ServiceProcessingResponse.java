package fog.globals.payloads;

import java.io.Serializable;

public class ServiceProcessingResponse implements Serializable {

    private boolean success;

    public ServiceProcessingResponse(boolean success) {
        this.success = success;
    }

    public ServiceProcessingResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ServiceProcessingResponse{" +
                "success=" + success +
                '}';
    }
}
