package com.capgemini.ccsw.estimador.criteriacalculation.model;


public class CriteriaDto {

    private String concept;

    private Double value;

    private String type;

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