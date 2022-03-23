package com.capgemini.ccsw.estimador.collaborator.model;

import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;
import com.capgemini.ccsw.estimador.user.model.UserDto;

/**
 * TODO asolerpa This type ...
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
