package com.ccsw.estimador.estimationparameter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.parameter.model.ParameterEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla
 *         estimation_parameters
 *
 */
@Entity
@Table(name = "estimation_parameters")
public class EstimationParameterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estimation")
    private EstimationEntity estimation;

    @ManyToOne
    @JoinColumn(name = "parameter")
    private ParameterEntity parameter;

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
     * @return parameter
     */
    public ParameterEntity getParameter() {

        return this.parameter;
    }

    /**
     * @param parameter new value of {@link #getparameter}.
     */
    public void setParameter(ParameterEntity parameter) {

        this.parameter = parameter;
    }

}
