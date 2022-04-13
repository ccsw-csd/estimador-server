package com.capgemini.ccsw.estimador.blockdurationcalculator.model;

import java.util.List;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

public class BlockDurationCalculatorDto {

    Double hours;

    List<CriteriaCalculationTransformationDto> criteriaList;

    List<FteDto> fteList;

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public List<CriteriaCalculationTransformationDto> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<CriteriaCalculationTransformationDto> criteriaList) {
        this.criteriaList = criteriaList;
    }

    public List<FteDto> getFteList() {
        return fteList;
    }

    public void setFteList(List<FteDto> fteList) {
        this.fteList = fteList;
    }
}
