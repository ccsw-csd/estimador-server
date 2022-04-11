package com.capgemini.ccsw.estimador.consideration.model;

import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad ConsiderationEntity
 *
 */
public class ConsiderationDto {

    private Long id;

    private EstimationDto estimation;

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
