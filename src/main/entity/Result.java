package searchService;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private String code;
    private String error;
    private List <String> fileNames = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getFileNames() {
        return fileNames;
    }



    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", error='" + error + '\'' +
                ", fileNames=" + fileNames +
                '}';
    }

    public void setFileNames(String fileName) {
            this.fileNames.add(fileName);
    }
}
