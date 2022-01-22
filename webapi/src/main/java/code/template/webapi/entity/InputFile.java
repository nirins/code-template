package code.template.webapi.entity;

public class InputFile {
    private String filePath;
    private String fileName;

    public InputFile(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFullPath(){
        return this.filePath + "/" + this.fileName;
    }
}
