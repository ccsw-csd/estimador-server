package com.capgemini.ccsw.estimador.estimation.model;

import java.util.Calendar;

import com.capgemini.ccsw.estimador.project.model.ProjectDto;
import com.capgemini.ccsw.estimador.user.model.UserDto;

/**
 * 
 * @author iciudade
 *
 */
public class EstimationDto {

	private Long id;
	
	private Calendar created;
	
	private UserDto createdBy;
	
	private String estVersion;
	
	private ProjectDto project;
	
	private Double totalCost;
	
	private Long totalDays;
	
	private Calendar lastUpdate;
	
	private int status;
	
	private Boolean showhours;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	public Calendar getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Calendar created) {
		this.created = created;
	}

	/**
	 * @return the createdBy
	 */
	public UserDto getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(UserDto createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the estVersion
	 */
	public String getEstVersion() {
		return estVersion;
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
		return project;
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
		return totalCost;
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
		return totalDays;
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
	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
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
		return showhours;
	}

	/**
	 * @param showhours the showhours to set
	 */
	public void setShowhours(Boolean showhours) {
		this.showhours = showhours;
	}

}
