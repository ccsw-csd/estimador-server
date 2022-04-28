package com.capgemini.ccsw.estimador.taskdevelopmenthours.model;

import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad TaskDevelopmentHoursEntity
 *
 */
public class TaskDevelopmentHoursDto {

    private Long id;

    private EstimationDto estimation;

    private String name;

    private Double quantity;

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
     * @return quantity
     */
    public Double getQuantity() {
        return this.quantity;
    }

    /**
     * @param quantity new value of {@link #getquantity}.
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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
