package payloads.acam.deviceTypes;

import java.util.List;

public class ListLatestDeviceTypeResponse {

    List<DeviceTypeDTO> deviceTypes;

    public ListLatestDeviceTypeResponse() {
    }

    public ListLatestDeviceTypeResponse(List<DeviceTypeDTO> deviceTypes) {
        this.deviceTypes = deviceTypes;
    }

    public List<DeviceTypeDTO> getDeviceTypes() {
        return deviceTypes;
    }

    public void setDeviceTypes(List<DeviceTypeDTO> deviceTypes) {
        this.deviceTypes = deviceTypes;
    }

    @Override
    public String toString() {
        return "ListLatestDeviceTypeResponse{" +
                "deviceTypes=" + deviceTypes +
                '}';
    }
}
