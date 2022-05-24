package com.capgemini.ccsw.estimador.criteriacalculation.model;

import com.capgemini.ccsw.estimador.block.model.BlockDto;

public class CriteriaCalculationTransformationDto {

    private Double hours;

    private BlockDto block;

    private String concept;

    public BlockDto getBlock() {

        return this.block;
    }

    public void setBlock(BlockDto block) {

        this.block = block;
    }

    public Double getHours() {

        return this.hours;
    }

    public void setHours(Double hours) {

        this.hours = hours;
    }

    /**
     * @return concept
     */
    public String getConcept() {

        return this.concept;
    }

    /**
     * @param concept new value of {@link #getconcept}.
     */
    public void setConcept(String concept) {

        this.concept = concept;
    }

}
