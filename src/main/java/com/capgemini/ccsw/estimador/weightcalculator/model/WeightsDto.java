package com.capgemini.ccsw.estimador.weightcalculator.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class WeightsDto {

    String element;

    @JsonAlias({ "verySimple" })
    Double verySimpleCost;

    @JsonAlias({ "simple" })
    Double simpleCost;

    @JsonAlias({ "medium" })
    Double mediumCost;

    @JsonAlias({ "complex" })
    Double complexCost;

    public String getElement() {

        return this.element;
    }

    public void setElement(String element) {

        this.element = element;
    }

    public Double getVerySimpleCost() {

        return this.verySimpleCost;
    }

    public void setVerySimpleCost(Double verySimpleCost) {

        this.verySimpleCost = verySimpleCost;
    }

    public Double getSimpleCost() {

        return this.simpleCost;
    }

    public void setSimpleCost(Double simpleCost) {

        this.simpleCost = simpleCost;
    }

    public Double getMediumCost() {

        return this.mediumCost;
    }

    public void setMediumCost(Double mediumCost) {

        this.mediumCost = mediumCost;
    }

    public Double getComplexCost() {

        return this.complexCost;
    }

    public void setComplexCost(Double complexCost) {

        this.complexCost = complexCost;
    }
}
