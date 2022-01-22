package code.template.webapi.entity;

public class ServiceResult {
    private String status;
    private String content;

    public ServiceResult(String status, String content) {
        this.status = status;
        this.content = content;
    }

    public String getStatus() {
        return this.status;
    }

    public String getContent() {
        return this.content;
    }
}
