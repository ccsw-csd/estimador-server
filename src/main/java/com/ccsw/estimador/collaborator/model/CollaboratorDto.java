package com.ccsw.estimador.collaborator.model;

import com.ccsw.estimador.estimation.model.EstimationDto;
import com.ccsw.estimador.user.model.UserDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad CollaboratorEntity
 *
 */
public class CollaboratorDto {

    private Long id;

    private EstimationDto estimation;

    private UserDto collaborator;

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
     * @return collaborator
     */
    public UserDto getCollaborator() {

        return this.collaborator;
    }

    /**
     * @param collaborator new value of {@link #getcollaborator}.
     */
    public void setCollaborator(UserDto collaborator) {

        this.collaborator = collaborator;
    }

}
