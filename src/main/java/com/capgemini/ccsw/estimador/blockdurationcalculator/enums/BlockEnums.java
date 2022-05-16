package com.capgemini.ccsw.estimador.blockdurationcalculator.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum BlockEnums {

    VOID("Void", 0, "Void"), //

    DEVELOPMENT("Desarrollo", 1, "COMMON"), //
    AUTOMATIC_TEST("Pruebas automáticas", 1, "COMMON"), //
    TESTING("Testing", 1, "COMMON"), //
    DEPLOY("Despliegue", 1, "COMMON"), //
    DOCUMENTATION("Documentación", 0.5f, "COMMON"), // 

    ARCHITECTURE("Arquitectura", 0.5f, "ARCHITECTURE"), //
    ANALYSIS("Análisis", 0.5f, "ANALYSIS"), // 
    UX("User eXperience", 0.5f, "UX");

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

        BlockEnums block = BY_LABEL.get(label);
        if (block != null)
            return block;

        return BlockEnums.VOID;
    }

}