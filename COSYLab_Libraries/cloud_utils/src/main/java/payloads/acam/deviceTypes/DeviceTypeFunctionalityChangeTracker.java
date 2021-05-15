package payloads.acam.deviceTypes;

public class DeviceTypeFunctionalityChangeTracker {

    private String serviceId;
    private String serviceName;
    private String humanReadableName;
    private DeviceFunctionalityUpdateAction action;
    private String oldServiceName;


    public DeviceTypeFunctionalityChangeTracker() {
    }

    public DeviceTypeFunctionalityChangeTracker(String serviceId, String serviceName, String humanReadableName, DeviceFunctionalityUpdateAction action) {

        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.humanReadableName = humanReadableName;
        this.action = action;
    }

    public DeviceTypeFunctionalityChangeTracker(String serviceId, String serviceName, String humanReadableName, DeviceFunctionalityUpdateAction action, String oldServiceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.humanReadableName = humanReadableName;
        this.action = action;
        this.oldServiceName = oldServiceName;
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

    public DeviceFunctionalityUpdateAction getAction() {
        return action;
    }

    public void setAction(DeviceFunctionalityUpdateAction action) {
        this.action = action;
    }

    public String getOldServiceName() {
        return oldServiceName;
    }

    public void setOldServiceName(String oldServiceName) {
        this.oldServiceName = oldServiceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "DeviceTypeFunctionalityChangeTracker{" +
                "serviceName='" + serviceName + '\'' +
                ", humanReadableName='" + humanReadableName + '\'' +
                ", action=" + action +
                ", oldServiceName='" + oldServiceName + '\'' +
                '}';
    }
}
