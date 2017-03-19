package org.codebird.code.entity.source;

import java.util.List;

/**
 * @author Sundeep
 */
public class Method {

    private AccessType accessType;
    private boolean isStatic;
    private boolean isFinal;
    private String name;
    private List<Argument> arguments;
    private String resultType;

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "Method{" + "accessType=" + accessType + ", isStatic=" + isStatic + ", isFinal=" + isFinal + ", name='" + name
            + '\'' + ", arguments=" + arguments + ", resultType='" + resultType + '\'' + '}';
    }
}
