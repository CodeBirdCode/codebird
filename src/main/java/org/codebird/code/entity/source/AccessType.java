package org.codebird.code.entity.source;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum AccessType {
    DEFAULT, PUBLIC, PRIVATE, PROTECTED;

    private static final Map<String, AccessType> nameToValueMap =
            new HashMap<>();

    static {
        for (AccessType value : EnumSet.allOf(AccessType.class)) {
            nameToValueMap.put(value.name().toLowerCase(), value);
        }
    }

    public static AccessType forName(String name) {
        return nameToValueMap.get(name.toLowerCase());
    }

};
