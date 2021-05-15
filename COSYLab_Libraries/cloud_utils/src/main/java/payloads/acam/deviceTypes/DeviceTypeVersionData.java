package payloads.acam.deviceTypes;

import java.util.Date;

public class DeviceTypeVersionData {

    private int ordinal;
    private String title;
    private String description;
    private Date createdAt;

    public DeviceTypeVersionData() {
    }

    public DeviceTypeVersionData(int ordinal, String title, String description, Date createdAt) {
        this.ordinal = ordinal;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "DeviceTypeVersionData{" +
                "ordinal=" + ordinal +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
