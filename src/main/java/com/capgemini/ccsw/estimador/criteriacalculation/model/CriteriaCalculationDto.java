package com.capgemini.ccsw.estimador.criteriacalculation.model;

import java.util.List;

public class CriteriaCalculationDto {

    private Double hours;

    private List<CriteriaDto> criteriaList;

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public List<CriteriaDto> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<CriteriaDto> criteriaList) {
        this.criteriaList = criteriaList;
    }

}