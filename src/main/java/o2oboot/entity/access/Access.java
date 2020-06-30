package o2oboot.entity.access;

public class Access {
    private Long accessId;
    private String accessName;
    private String url;
    private int accessNumber;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(int accessNumber) {
        this.accessNumber = accessNumber;
    }

    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }
}
