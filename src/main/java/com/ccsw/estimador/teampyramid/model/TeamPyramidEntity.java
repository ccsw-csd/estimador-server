package com.ccsw.estimador.teampyramid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.profile.model.ProfileEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla team_pyramid
 *
 */
@Entity
@Table(name = "team_pyramid")
public class TeamPyramidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estimation")
    private EstimationEntity estimation;

    @ManyToOne
    @JoinColumn(name = "profile")
    private ProfileEntity profile;

    @JoinColumn(name = "fte")
    private Double fte;

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
     * @return profile
     */
    public ProfileEntity getProfile() {

        return this.profile;
    }

    /**
     * @param profile new value of {@link #getprofile}.
     */
    public void setProfile(ProfileEntity profile) {

        this.profile = profile;
    }

    /**
     * @return fte
     */
    public Double getFte() {

        return this.fte;
    }

    /**
     * @param fte new value of {@link #getfte}.
     */
    public void setFte(Double fte) {

        this.fte = fte;
    }

}
