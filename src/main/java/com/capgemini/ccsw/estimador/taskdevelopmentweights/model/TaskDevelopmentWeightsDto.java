package com.capgemini.ccsw.estimador.taskdevelopmentweights.model;

import com.capgemini.ccsw.estimador.elementweight.model.ElementWeightDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad TaskDevelopmentWeightsEntity
 *
 */
public class TaskDevelopmentWeightsDto {

    private Long id;

    private String name;

    private ElementWeightDto workElementWeight;

    private Double quantityVerySimple;

    private Double quantitySimple;

    private Double quantityMedium;

    private Double quantityComplex;

    private Double reusability;

    private Double hours;

    private String comment;

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
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name new value of {@link #getname}.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return workElementWeight
     */
    public ElementWeightDto getWorkElementWeight() {
        return this.workElementWeight;
    }

    /**
     * @param workElementWeight new value of {@link #getworkElementWeight}.
     */
    public void setWorkElementWeight(ElementWeightDto workElementWeight) {
        this.workElementWeight = workElementWeight;
    }

    /**
     * @return quantityVerySimple
     */
    public Double getQuantityVerySimple() {
        return this.quantityVerySimple;
    }

    /**
     * @param quantityVerySimple new value of {@link #getquantityVerySimple}.
     */
    public void setQuantityVerySimple(Double quantityVerySimple) {
        this.quantityVerySimple = quantityVerySimple;
    }

    /**
     * @return quantitySimple
     */
    public Double getQuantitySimple() {
        return this.quantitySimple;
    }

    /**
     * @param quantitySimple new value of {@link #getquantitySimple}.
     */
    public void setQuantitySimple(Double quantitySimple) {
        this.quantitySimple = quantitySimple;
    }

    /**
     * @return quantityMedium
     */
    public Double getQuantityMedium() {
        return this.quantityMedium;
    }

    /**
     * @param quantityMedium new value of {@link #getquantityMedium}.
     */
    public void setQuantityMedium(Double quantityMedium) {
        this.quantityMedium = quantityMedium;
    }

    /**
     * @return quantityComplex
     */
    public Double getQuantityComplex() {
        return this.quantityComplex;
    }

    /**
     * @param quantityComplex new value of {@link #getquantityComplex}.
     */
    public void setQuantityComplex(Double quantityComplex) {
        this.quantityComplex = quantityComplex;
    }

    /**
     * @return reusability
     */
    public Double getReusability() {
        return this.reusability;
    }

    /**
     * @param reusability new value of {@link #getreusability}.
     */
    public void setReusability(Double reusability) {
        this.reusability = reusability;
    }

    /**
     * @return hours
     */
    public Double getHours() {
        return this.hours;
    }

    /**
     * @param hours new value of {@link #gethours}.
     */
    public void setHours(Double hours) {
        this.hours = hours;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @param comment new value of {@link #getcomment}.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

}
