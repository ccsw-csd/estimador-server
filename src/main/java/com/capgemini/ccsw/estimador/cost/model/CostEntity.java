package com.capgemini.ccsw.estimador.cost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla cost
 *
 */
@Entity
@Table(name = "cost")
public class CostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estimation", nullable = false)
    private EstimationEntity estimation;

    @Column(name = "cost_a")
    private Double costGradeA;

    @Column(name = "cost_b")
    private Double costGradeB;

    @Column(name = "cost_c")
    private Double costGradeC;

    @Column(name = "cost_d")
    private Double costGradeD;

    @Column(name = "margin_a")
    private Double marginGradeA;

    @Column(name = "margin_b")
    private Double marginGradeB;

    @Column(name = "margin_c")
    private Double marginGradeC;

    @Column(name = "margin_d")
    private Double marginGradeD;

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
    public EstimationEntity getEstimation() {
        return this.estimation;
    }

    /**
     * @param estimation new value of {@link #getestimation}.
     */
    public void setEstimation(EstimationEntity estimation) {
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

    /**
     * @return the marginGradeA
     */
    public Double getMarginGradeA() {
        return marginGradeA;
    }

    /**
     * @param marginGradeA the marginGradeA to set
     */
    public void setMarginGradeA(Double marginGradeA) {
        this.marginGradeA = marginGradeA;
    }

    /**
     * @return the marginGradeB
     */
    public Double getMarginGradeB() {
        return marginGradeB;
    }

    /**
     * @param marginGradeB the marginGradeB to set
     */
    public void setMarginGradeB(Double marginGradeB) {
        this.marginGradeB = marginGradeB;
    }

    /**
     * @return the marginGradeC
     */
    public Double getMarginGradeC() {
        return marginGradeC;
    }

    /**
     * @param marginGradeC the marginGradeC to set
     */
    public void setMarginGradeC(Double marginGradeC) {
        this.marginGradeC = marginGradeC;
    }

    /**
     * @return the marginGradeD
     */
    public Double getMarginGradeD() {
        return marginGradeD;
    }

    /**
     * @param marginGradeD the marginGradeD to set
     */
    public void setMarginGradeD(Double marginGradeD) {
        this.marginGradeD = marginGradeD;
    }

}
