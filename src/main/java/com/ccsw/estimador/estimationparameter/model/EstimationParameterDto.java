package com.ccsw.estimador.estimationparameter.model;

import com.ccsw.estimador.estimation.model.EstimationDto;
import com.ccsw.estimador.parameter.model.ParameterDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad EstimationParameterEntity
 *
 */
public class EstimationParameterDto {

    private Long id;

    private EstimationDto estimation;

    private ParameterDto parameter;

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
     * @return parameter
     */
    public ParameterDto getParameter() {

        return this.parameter;
    }

    /**
     * @param parameter new value of {@link #getparameter}.
     */
    public void setParameter(ParameterDto parameter) {

        this.parameter = parameter;
    }

}
