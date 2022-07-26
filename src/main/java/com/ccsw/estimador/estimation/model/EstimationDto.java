package com.ccsw.estimador.estimation.model;

import java.util.Date;

import com.ccsw.estimador.project.model.ProjectDto;
import com.ccsw.estimador.user.model.UserDto;

/**
 *
 * @author iciudade
 *
 */
public class EstimationDto {

    private Long id;

    private Date created;

    private String estVersion;

    private ProjectDto project;

    private Double totalCost;

    private Long totalDays;

    private Date lastUpdate;

    private int status;

    private Boolean showhours;

    private UserDto createdBy;

    /**
     * @return the id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return the created
     */
    public Date getCreated() {

        return this.created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {

        this.created = created;
    }

    /**
     * @return the estVersion
     */
    public String getEstVersion() {

        return this.estVersion;
    }

    /**
     * @param estVersion the estVersion to set
     */
    public void setEstVersion(String estVersion) {

        this.estVersion = estVersion;
    }

    /**
     * @return the project
     */
    public ProjectDto getProject() {

        return this.project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(ProjectDto project) {

        this.project = project;
    }

    /**
     * @return the totalCost
     */
    public Double getTotalCost() {

        return this.totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(Double totalCost) {

        this.totalCost = totalCost;
    }

    /**
     * @return the totalDays
     */
    public Long getTotalDays() {

        return this.totalDays;
    }

    /**
     * @param totalDays the totalDays to set
     */
    public void setTotalDays(Long totalDays) {

        this.totalDays = totalDays;
    }

    /**
     * @return the lastUpdate
     */
    public Date getLastUpdate() {

        return this.lastUpdate;
    }

    /**
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(Date lastUpdate) {

        this.lastUpdate = lastUpdate;
    }

    /**
     * @return the status
     */
    public int getStatus() {

        return this.status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {

        this.status = status;
    }

    /**
     * @return the showhours
     */
    public Boolean getShowhours() {

        return this.showhours;
    }

    /**
     * @param showhours the showhours to set
     */
    public void setShowhours(Boolean showhours) {

        this.showhours = showhours;
    }

    /**
     * @return createdBy
     */
    public UserDto getCreatedBy() {

        return this.createdBy;
    }

    /**
     * @param createdBy new value of {@link #getcreatedBy}.
     */
    public void setCreatedBy(UserDto createdBy) {

        this.createdBy = createdBy;
    }

}
