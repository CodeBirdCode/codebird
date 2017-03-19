package org.codebird.code.entity.source;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Sundeep on 19/03/2017.
 */
public class ClassInfo {

    private final String name;
    private final String packageName;
    private final String fullName;
    private static final StringJoiner joiner = new StringJoiner(".");
    private final List<Method> methodList = new ArrayList<>();
    private final List<String> importList = new ArrayList<>();
    private final List<Field> fieldList = new ArrayList<>();

    public ClassInfo(String name, String packageName) {
        this.name = name;
        this.packageName = packageName;
        this.fullName = joiner.add(packageName).add(name).toString();
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public List<String> getImportList() {
        return importList;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }
}
