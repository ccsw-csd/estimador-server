package com.capgemini.ccsw.estimador.blockdurationcalculator.model;

public class BlockDurationTransformatedDto {

    String blockName;

    Double totalHours = 0d;

    Double duration = 0d;

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
        return totalHours;
    }

    public void setHours(Double totalHours) {
        this.totalHours = totalHours;
    }
}
