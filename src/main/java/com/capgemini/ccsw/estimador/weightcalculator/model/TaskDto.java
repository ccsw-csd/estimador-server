package com.capgemini.ccsw.estimador.weightcalculator.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TaskDto {

    String name;

    @JsonAlias({ "elementName" })
    String element;

    @JsonAlias({ "quantityVerySimple" })
    Double verySimpleCostQuantity;

    @JsonAlias({ "quantitySimple" })
    Double simpleCostQuantity;

    @JsonAlias({ "quantityMedium" })
    Double mediumCostQuantity;

    @JsonAlias({ "quantityComplex" })
    Double complexCostQuantity;

    @JsonAlias({ "reusability" })
    Double percentageOfReuse;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Double getVerySimpleCostQuantity() {
        return this.verySimpleCostQuantity;
    }

    public void setVerySimpleCostQuantity(Double verySimpleCostQuantity) {
        this.verySimpleCostQuantity = verySimpleCostQuantity;
    }

    public Double getSimpleCostQuantity() {
        return this.simpleCostQuantity;
    }

    public void setSimpleCostQuantity(Double simpleCostQuantity) {
        this.simpleCostQuantity = simpleCostQuantity;
    }

    public Double getMediumCostQuantity() {
        return this.mediumCostQuantity;
    }

    public void setMediumCostQuantity(Double mediumCostQuantity) {
        this.mediumCostQuantity = mediumCostQuantity;
    }

    public Double getComplexCostQuantity() {
        return this.complexCostQuantity;
    }

    public void setComplexCostQuantity(Double complexCostQuantity) {
        this.complexCostQuantity = complexCostQuantity;
    }

    public Double getPercentageOfReuse() {
        return this.percentageOfReuse;
    }

    public void setPercentageOfReuse(Double percentageOfReuse) {
        this.percentageOfReuse = percentageOfReuse;
    }
}
