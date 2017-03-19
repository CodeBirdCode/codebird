package org.codebird.code.entity.source;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sundeep on 19/03/2017.
 */
public class JavaFile {

    private final String filePath;
    private String fileNameWithoutExtension;
    private final List<ClassInfo> classInfoList = new ArrayList<>();

    public JavaFile(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileNameWithoutExtension() {
        return fileNameWithoutExtension;
    }

    public void setFileNameWithoutExtension(String fileNameWithoutExtension) {
        this.fileNameWithoutExtension = fileNameWithoutExtension;
    }

    public List<ClassInfo> getClassInfoList() {
        return classInfoList;
    }
}
