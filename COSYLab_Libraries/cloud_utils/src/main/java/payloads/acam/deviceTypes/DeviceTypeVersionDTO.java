package payloads.acam.deviceTypes;

import java.util.List;

public class DeviceTypeVersionDTO {

    private String deviceTypeId;
    private String typeName;
    private String serviceProvider;

    private List<VersionChangeLogDTO> versions;


    public DeviceTypeVersionDTO() {
    }

    public DeviceTypeVersionDTO(String deviceTypeId, String typeName, String serviceProvider, List<VersionChangeLogDTO> versions) {
        this.deviceTypeId = deviceTypeId;
        this.typeName = typeName;
        this.serviceProvider = serviceProvider;
        this.versions = versions;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public List<VersionChangeLogDTO> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionChangeLogDTO> versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {
        return "DeviceTypeVersionDTO{" +
                "deviceTypeId='" + deviceTypeId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                ", versions=" + versions +
                '}';
    }
}
