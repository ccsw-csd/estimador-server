package com.capgemini.ccsw.estimador.costpergrade.model;

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
public class CostPerGradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estimation", nullable = false)
    private EstimationEntity estimation;

    @Column(name = "a")
    private Double costGradeA;

    @Column(name = "b")
    private Double costGradeB;

    @Column(name = "c")
    private Double costGradeC;

    @Column(name = "d")
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
}
