package org.codebird.code.entity.source;

/**
 * @author Sundeep
 */
public class Field {

    private static final String MODIFIER_STATIC = "static";
    private static final String MODIFIER_FINAL = "final";

    private AccessType accessType;
    private String type;
    private String name;
    private boolean isStatic;
    private boolean isFinal;

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean xStatic) {
        isStatic = xStatic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean xFinal) {
        isFinal = xFinal;
    }

    public void setModifier(String modifier) {
        AccessType access = AccessType.forName(modifier);
        if(access != null) {
            accessType = access;
        } else if(modifier.equals(MODIFIER_STATIC)){
            isStatic = true;
        } else if(modifier.equals(MODIFIER_FINAL)) {
            isFinal = true;
        }
    }

    @Override
    public String toString() {
        return "Field{" +
                "accessType=" + accessType +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", isStatic=" + isStatic +
                ", isFinal=" + isFinal +
                '}';
    }
}
