package com.capgemini.ccsw.estimador.blockdurationcalculator.model;

public class BlockDurationTransformatedDto {

    String blockName;

    Double hours = 0d;

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }
}
