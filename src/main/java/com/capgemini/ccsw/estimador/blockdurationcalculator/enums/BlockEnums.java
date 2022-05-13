package com.capgemini.ccsw.estimador.blockdurationcalculator.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum BlockEnums {
    DEVELOPMENT("DEVELOPMENT", 1, "COMMON"), //
    TESTING("TESTING", 0.5f, "COMMON"), //
    DEPLOY("DEPLOY", 1, "COMMON"), //
    DOCUMENTATION("DOCUMENTATION", 0.75f, "COMMON"), // 
    ARCHITECTURE("ARCHITECTURE", 0.5f, "ARCHITECTURE"), //
    ANALYSIS("ANALYSIS", 0.5f, "ANALYSIS"), // 
    UX("UX", 0.5f, "UX");

    public final float weight;
    public final String label;
    public final String type;

    BlockEnums(String label, float weight, String type) {
        this.weight = weight;
        this.label = label;
        this.type = type;
    }

    public static Stream<BlockEnums> stream() {
        return Stream.of(BlockEnums.values());
    }

    private static final Map<String, BlockEnums> BY_LABEL = new HashMap<>();

    static {
        for (BlockEnums e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public static BlockEnums valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}