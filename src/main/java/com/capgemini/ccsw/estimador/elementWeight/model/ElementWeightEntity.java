package com.capgemini.ccsw.estimador.elementWeight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.estimationLevel.model.EstimationLevelEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla
 *         work_element_weights
 *
 */
@Entity
@Table(name = "work_element_weights")
public class ElementWeightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String element;

    @Column(name = "vs")
    private Double verySimple;

    @Column(name = "s")
    private Double simple;

    @Column(name = "m")
    private Double medium;

    @Column(name = "c")
    private Double complex;

    @ManyToOne
    @JoinColumn(name = "lvl")
    private EstimationLevelEntity level;

    @ManyToOne
    @JoinColumn(name = "estimation")
    private EstimationEntity estimation;

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
     * @return element
     */
    public String getElement() {

        return this.element;
    }

    /**
     * @param element new value of {@link #getelement}.
     */
    public void setElement(String element) {

        this.element = element;
    }

    /**
     * @return verySimple
     */
    public Double getVerySimple() {

        return this.verySimple;
    }

    /**
     * @param verySimple new value of {@link #getverySimple}.
     */
    public void setVerySimple(Double verySimple) {

        this.verySimple = verySimple;
    }

    /**
     * @return simple
     */
    public Double getSimple() {

        return this.simple;
    }

    /**
     * @param simple new value of {@link #getsimple}.
     */
    public void setSimple(Double simple) {

        this.simple = simple;
    }

    /**
     * @return medium
     */
    public Double getMedium() {

        return this.medium;
    }

    /**
     * @param medium new value of {@link #getmedium}.
     */
    public void setMedium(Double medium) {

        this.medium = medium;
    }

    /**
     * @return complex
     */
    public Double getComplex() {

        return this.complex;
    }

    /**
     * @param complex new value of {@link #getcomplex}.
     */
    public void setComplex(Double complex) {

        this.complex = complex;
    }

    /**
     * @return level
     */
    public EstimationLevelEntity getLevel() {

        return this.level;
    }

    /**
     * @param level new value of {@link #getlevel}.
     */
    public void setLevel(EstimationLevelEntity level) {

        this.level = level;
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

}
