package payloads.acam.deviceTypes;

import java.util.Date;
import java.util.List;

public class VersionChangeLogDTO {

    private String versionNumber;
    private Date timestamp;
    private String changeLog;
    private int ordinal;

    private List<DeviceTypeFunctionalityChangeTracker> functionalities;

    public VersionChangeLogDTO() {
    }

    public VersionChangeLogDTO(String versionNumber, Date timestamp, String changeLog, List<DeviceTypeFunctionalityChangeTracker> functionalities, int ordinal) {
        this.versionNumber = versionNumber;
        this.timestamp = timestamp;
        this.changeLog = changeLog;
        this.functionalities = functionalities;
        this.ordinal = ordinal;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getChangeLog() {
        return changeLog;
    }

    public void setChangeLog(String changeLog) {
        this.changeLog = changeLog;
    }

    public List<DeviceTypeFunctionalityChangeTracker> getFunctionalities() {
        return functionalities;
    }

    public void setFunctionalities(List<DeviceTypeFunctionalityChangeTracker> functionalities) {
        this.functionalities = functionalities;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public String toString() {
        return "VersionChangeLog{" +
                ", versionNumber='" + versionNumber + '\'' +
                ", timestamp=" + timestamp +
                ", changeLog='" + changeLog + '\'' +
                ", functionalities=" + functionalities +
                ", ordinal=" + ordinal +
                '}';
    }
}
