package payloads.acam.deviceTypes;

import java.util.List;

public class DeviceTypeDTO {

    private String id;
    private String typeName;

    private String serviceProvider;
    //Key - Human readable functionality name, Value - Service readable functionality

    private List<DeviceTypeFunctionality> functionalities;

    private DeviceTypeVersionData currentVersion;

    public DeviceTypeDTO() {
    }

    public DeviceTypeDTO(String id, String typeName, String serviceProvider, List<DeviceTypeFunctionality> functionalities, DeviceTypeVersionData currentVersion) {
        this.id = id;
        this.typeName = typeName;
        this.serviceProvider = serviceProvider;
        this.functionalities = functionalities;
        this.currentVersion = currentVersion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<DeviceTypeFunctionality> getFunctionalities() {
        return functionalities;
    }

    public void setFunctionalities(List<DeviceTypeFunctionality> functionalities) {
        this.functionalities = functionalities;
    }

    public DeviceTypeVersionData getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(DeviceTypeVersionData currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String toString() {
        String str = typeName + " functionality-List:\n";
        for (DeviceTypeFunctionality function : functionalities) {
            str += function + "\n";
        }
        return str;
    }
}
