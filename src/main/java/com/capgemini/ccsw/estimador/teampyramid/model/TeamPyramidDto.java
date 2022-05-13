package com.capgemini.ccsw.estimador.teampyramid.model;

import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;
import com.capgemini.ccsw.estimador.profile.model.ProfileDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad TeamPyramidEntity
 *
 */
public class TeamPyramidDto {

    private Long id;

    private EstimationDto estimation;

    private ProfileDto profile;

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
     * @return profile
     */
    public ProfileDto getProfile() {

        return this.profile;
    }

    /**
     * @param profile new value of {@link #getprofile}.
     */
    public void setProfile(ProfileDto profile) {

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
