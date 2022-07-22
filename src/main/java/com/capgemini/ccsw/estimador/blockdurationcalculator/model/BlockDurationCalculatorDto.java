package com.capgemini.ccsw.estimador.blockdurationcalculator.model;

import java.util.List;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

public class BlockDurationCalculatorDto {

    private Double hours;
    private Double archytectureHours;
    private List<CriteriaCalculationTransformationDto> criteriaList;
    private List<FteDto> fteList;

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

    /**
     * @return the archytectureHours
     */
    public Double getArchytectureHours() {
        return archytectureHours;
    }

    /**
     * @param archytectureHours the archytectureHours to set
     */
    public void setArchytectureHours(Double archytectureHours) {
        this.archytectureHours = archytectureHours;
    }
}
