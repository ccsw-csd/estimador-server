package com.capgemini.ccsw.criteriaCalculation.model;

import java.util.List;

public class CriteriaCalculationBodyDto {

    private Double hours;

    private List<CriteriaCalculationDto> criteriaList;

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public List<CriteriaCalculationDto> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<CriteriaCalculationDto> criteriaList) {
        this.criteriaList = criteriaList;
    }

}
