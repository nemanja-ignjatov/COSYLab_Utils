package payloads.acam.deviceTypes;

public class DeviceTypeVersionUpdateRequest {

    private String deviceTypeId;
    private int versionOrdinal;

    public DeviceTypeVersionUpdateRequest() {
    }

    public DeviceTypeVersionUpdateRequest(String deviceTypeId, int versionOrdinal) {
        this.deviceTypeId = deviceTypeId;
        this.versionOrdinal = versionOrdinal;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public int getVersionOrdinal() {
        return versionOrdinal;
    }

    public void setVersionOrdinal(int versionOrdinal) {
        this.versionOrdinal = versionOrdinal;
    }

    @Override
    public String toString() {
        return "DeviceTypeVersionUpdateRequest{" +
                "deviceTypeId='" + deviceTypeId + '\'' +
                ", versionOrdinal=" + versionOrdinal +
                '}';
    }
}
