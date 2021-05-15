package payloads.acam.deviceTypes;

import java.util.List;

public class ListDeviceTypesChangeUpdatesResponse {

    List<DeviceTypeVersionDTO> deviceTypeVersions;

    public ListDeviceTypesChangeUpdatesResponse() {
    }

    public ListDeviceTypesChangeUpdatesResponse(List<DeviceTypeVersionDTO> deviceTypeVersions) {
        this.deviceTypeVersions = deviceTypeVersions;
    }

    public List<DeviceTypeVersionDTO> getDeviceTypeVersions() {
        return deviceTypeVersions;
    }

    public void setDeviceTypeVersions(List<DeviceTypeVersionDTO> deviceTypeVersions) {
        this.deviceTypeVersions = deviceTypeVersions;
    }

    @Override
    public String toString() {
        return "ListDeviceTypesChangeUpdatesResponse{" +
                "deviceTypeVersions=" + deviceTypeVersions +
                '}';
    }
}
