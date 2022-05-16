package com.capgemini.ccsw.estimador.criteriacalculation.model;

import com.capgemini.ccsw.estimador.block.model.BlockDto;

public class CriteriaCalculationTransformationDto {

    private Double hours;

    private BlockDto block;

    public BlockDto getBlock() {
        return block;
    }

    public void setBlock(BlockDto block) {
        this.block = block;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

}
