package com.ccsw.estimador.elementweight.model;

import com.ccsw.estimador.estimationlevel.model.EstimationLevelDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad ElementWeightEntity
 *
 */
public class ElementWeightDto {

    private Long id;

    private String element;

    private Double verySimple;

    private Double simple;

    private Double medium;

    private Double complex;

    private EstimationLevelDto level;

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
    public EstimationLevelDto getLevel() {

        return this.level;
    }

    /**
     * @param level new value of {@link #getlevel}.
     */
    public void setLevel(EstimationLevelDto level) {

        this.level = level;
    }

}
