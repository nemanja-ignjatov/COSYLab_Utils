package payloads.acam.deviceTypes;

import java.io.Serializable;
import java.util.List;

public class ListDeviceTypesChangeUpdatesRequest implements Serializable {

    List<DeviceTypeVersionUpdateRequest> requestItems;

    public ListDeviceTypesChangeUpdatesRequest() {
    }

    public ListDeviceTypesChangeUpdatesRequest(List<DeviceTypeVersionUpdateRequest> requestItems) {
        this.requestItems = requestItems;
    }

    public List<DeviceTypeVersionUpdateRequest> getRequestItems() {
        return requestItems;
    }

    public void setRequestItems(List<DeviceTypeVersionUpdateRequest> requestItems) {
        this.requestItems = requestItems;
    }

    @Override
    public String toString() {
        return "ListDeviceTypesChangeUpdatesResponse{" +
                "requestItems=" + requestItems +
                '}';
    }
}
