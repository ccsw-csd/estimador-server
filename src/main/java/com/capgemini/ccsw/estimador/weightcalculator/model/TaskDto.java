package com.capgemini.ccsw.estimador.weightcalculator.model;

public class TaskDto {

    String name;

    String element;

    Double verySimpleCostQuantity;

    Double simpleCostQuantity;

    Double costQuantity;

    Double complexCostQuantity;

    Double percentageOfReuse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Double getVerySimpleCostQuantity() {
        return verySimpleCostQuantity;
    }

    public void setVerySimpleCostQuantity(Double verySimpleCostQuantity) {
        this.verySimpleCostQuantity = verySimpleCostQuantity;
    }

    public Double getSimpleCostQuantity() {
        return simpleCostQuantity;
    }

    public void setSimpleCostQuantity(Double simpleCostQuantity) {
        this.simpleCostQuantity = simpleCostQuantity;
    }

    public Double getCostQuantity() {
        return costQuantity;
    }

    public void setCostQuantity(Double costQuantity) {
        this.costQuantity = costQuantity;
    }

    public Double getComplexCostQuantity() {
        return complexCostQuantity;
    }

    public void setComplexCostQuantity(Double complexCostQuantity) {
        this.complexCostQuantity = complexCostQuantity;
    }

    public Double getPercentageOfReuse() {
        return percentageOfReuse;
    }

    public void setPercentageOfReuse(Double percentageOfReuse) {
        this.percentageOfReuse = percentageOfReuse;
    }
}
