package com.capgemini.ccsw.estimador.weightcalculator.model;

public class WeightsDto {

    String element;

    Double verySimpleCost;

    Double simpleCost;

    Double mediumCost;

    Double complexCost;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Double getVerySimpleCost() {
        return verySimpleCost;
    }

    public void setVerySimpleCost(Double verySimpleCost) {
        this.verySimpleCost = verySimpleCost;
    }

    public Double getSimpleCost() {
        return simpleCost;
    }

    public void setSimpleCost(Double simpleCost) {
        this.simpleCost = simpleCost;
    }

    public Double getMediumCost() {
        return mediumCost;
    }

    public void setMediumCost(Double mediumCost) {
        this.mediumCost = mediumCost;
    }

    public Double getComplexCost() {
        return complexCost;
    }

    public void setComplexCost(Double complexCost) {
        this.complexCost = complexCost;
    }
}
