package com.capgemini.ccsw.estimador.costpergrade.model;

import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad CostPerGradeEntity
 *
 */
public class CostPerGradeDto {

    private Long id;

    private EstimationDto estimation;

    private Double costGradeA;

    private Double costGradeB;

    private Double costGradeC;

    private Double costGradeD;

    /**
     * @return id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id new value of {@link #getid}.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return estimation
     */
    public EstimationDto getEstimation() {
        return this.estimation;
    }

    /**
     * @param estimation new value of {@link #getestimation}.
     */
    public void setEstimation(EstimationDto estimation) {
        this.estimation = estimation;
    }

    /**
     * @return costGradeA
     */
    public Double getCostGradeA() {
        return this.costGradeA;
    }

    /**
     * @param costGradeA new value of {@link #getcostGradeA}.
     */
    public void setCostGradeA(Double costGradeA) {
        this.costGradeA = costGradeA;
    }

    /**
     * @return costGradeB
     */
    public Double getCostGradeB() {
        return this.costGradeB;
    }

    /**
     * @param costGradeB new value of {@link #getcostGradeB}.
     */
    public void setCostGradeB(Double costGradeB) {
        this.costGradeB = costGradeB;
    }

    /**
     * @return costGradeC
     */
    public Double getCostGradeC() {
        return this.costGradeC;
    }

    /**
     * @param costGradeC new value of {@link #getcostGradeC}.
     */
    public void setCostGradeC(Double costGradeC) {
        this.costGradeC = costGradeC;
    }

    /**
     * @return costGradeD
     */
    public Double getCostGradeD() {
        return this.costGradeD;
    }

    /**
     * @param costGradeD new value of {@link #getcostGradeD}.
     */
    public void setCostGradeD(Double costGradeD) {
        this.costGradeD = costGradeD;
    }
}
