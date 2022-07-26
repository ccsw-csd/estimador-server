package com.ccsw.estimador.collaborator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.user.model.UserEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla
 *         estimation_collaborators
 *
 */
@Entity
@Table(name = "estimation_collaborators")
public class CollaboratorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estimation")
    private EstimationEntity estimation;

    @ManyToOne
    @JoinColumn(name = "collaborator")
    private UserEntity collaborator;

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
     * @return collaborator
     */
    public UserEntity getCollaborator() {

        return this.collaborator;
    }

    /**
     * @param collaborator new value of {@link #getcollaborator}.
     */
    public void setCollaborator(UserEntity collaborator) {

        this.collaborator = collaborator;
    }

}
