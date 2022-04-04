package com.capgemini.ccsw.estimador.criteriacalculation.model;


public class CriteriaCalculationDto {

    private String concept;

    private double value;

    private String type;

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}