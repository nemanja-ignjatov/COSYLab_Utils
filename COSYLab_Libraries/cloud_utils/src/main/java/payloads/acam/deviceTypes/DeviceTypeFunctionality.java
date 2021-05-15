package payloads.acam.deviceTypes;

import utils.CryptoUtilFunctions;

public class DeviceTypeFunctionality {

    private String id;
    private String serviceName;
    private String humanReadableName;

    public DeviceTypeFunctionality() {
    }

    public DeviceTypeFunctionality(String serviceName, String humanReadableName) {
        this.id = CryptoUtilFunctions.generateUUID();
        this.serviceName = serviceName;
        this.humanReadableName = humanReadableName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHumanReadableName() {
        return humanReadableName;
    }

    public void setHumanReadableName(String humanReadableName) {
        this.humanReadableName = humanReadableName;
    }

    @Override
    public String toString() {
        return "DeviceTypeFunctionality{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", humanReadableName='" + humanReadableName + '\'' +
                '}';
    }
}
