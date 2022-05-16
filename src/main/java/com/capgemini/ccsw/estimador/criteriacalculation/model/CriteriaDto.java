package com.capgemini.ccsw.estimador.criteriacalculation.model;

import com.capgemini.ccsw.estimador.block.model.BlockDto;

public class CriteriaDto {

    private BlockDto block;

    private String concept;

    private Double value;

    private String type;

    public BlockDto getBlock() {
        return block;
    }

    public void setBlock(BlockDto block) {
        this.block = block;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}