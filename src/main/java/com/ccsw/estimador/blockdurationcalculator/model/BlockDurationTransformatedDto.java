package com.ccsw.estimador.blockdurationcalculator.model;

public class BlockDurationTransformatedDto {

    String blockName;

    Double hours = 0d;

    Double duration = 0d;

    public Double getWorkdays() {
        return hours / 8;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

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
