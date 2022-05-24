package com.capgemini.ccsw.estimador.estimation.model;

import java.util.Date;
import java.util.List;

import com.capgemini.ccsw.estimador.consideration.model.ConsiderationDto;
import com.capgemini.ccsw.estimador.elementweight.model.ElementWeightDto;
import com.capgemini.ccsw.estimador.parameter.model.ParameterDto;
import com.capgemini.ccsw.estimador.project.model.ProjectDto;
import com.capgemini.ccsw.estimador.taskarchitecture.model.TaskArchitectureDto;
import com.capgemini.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursDto;
import com.capgemini.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsDto;
import com.capgemini.ccsw.estimador.user.model.UserDto;

/**
 *
 * @author pajimene
 *
 */
public class EstimationEditDto {

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

    private List<UserDto> collaborators;

    private List<ElementWeightDto> elementWeight;

    private List<ParameterDto> parameters;

    private List<TaskArchitectureDto> architectureTasks;

    private List<TaskDevelopmentHoursDto> developmentTasks;

    private List<TaskDevelopmentWeightsDto> developmentWeights;

    private List<ConsiderationDto> considerations;

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

    public void setCollaborators(List<UserDto> collaborators) {
        this.collaborators = collaborators;
    }

    /**
     * @return the collaborators
     */
    public List<UserDto> getCollaborators() {
        return collaborators;
    }

    /**
     * @return the elementWeight
     */
    public List<ElementWeightDto> getElementWeight() {
        return elementWeight;
    }

    /**
     * @param elementWeight the elementWeight to set
     */
    public void setElementWeight(List<ElementWeightDto> elementWeight) {
        this.elementWeight = elementWeight;
    }

    /**
     * @return the parameters
     */
    public List<ParameterDto> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(List<ParameterDto> parameters) {
        this.parameters = parameters;
    }

    /**
     * @return the architectureTasks
     */
    public List<TaskArchitectureDto> getArchitectureTasks() {
        return architectureTasks;
    }

    /**
     * @param architectureTasks the architectureTasks to set
     */
    public void setArchitectureTasks(List<TaskArchitectureDto> architectureTasks) {
        this.architectureTasks = architectureTasks;
    }

    /**
     * @return the developmentTasks
     */
    public List<TaskDevelopmentHoursDto> getDevelopmentTasks() {
        return developmentTasks;
    }

    /**
     * @param developmentTasks the developmentTasks to set
     */
    public void setDevelopmentTasks(List<TaskDevelopmentHoursDto> developmentTasks) {
        this.developmentTasks = developmentTasks;
    }

    /**
     * @return the developmentWeights
     */
    public List<TaskDevelopmentWeightsDto> getDevelopmentWeights() {
        return developmentWeights;
    }

    /**
     * @param developmentWeights the developmentWeights to set
     */
    public void setDevelopmentWeights(List<TaskDevelopmentWeightsDto> developmentWeights) {
        this.developmentWeights = developmentWeights;
    }

    /**
     * @return the considerations
     */
    public List<ConsiderationDto> getConsiderations() {
        return considerations;
    }

    /**
     * @param considerations the considerations to set
     */
    public void setConsiderations(List<ConsiderationDto> considerations) {
        this.considerations = considerations;
    }

}
