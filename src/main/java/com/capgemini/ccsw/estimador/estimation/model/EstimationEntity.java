package com.capgemini.ccsw.estimador.estimation.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.ccsw.estimador.project.model.ProjectEntity;
import com.capgemini.ccsw.estimador.user.model.UserEntity;

/**
 * @author iciudade
 */
@Entity
@Table(name = "estimation")
public class EstimationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "created", nullable = false)
	private Calendar created;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private UserEntity createdBy;
	
	@Column(name = "est_version", nullable = false)
	private String estVersion;
	
	@ManyToOne
	@JoinColumn(name = "project", nullable = false)
	private ProjectEntity project;
	
	@Column(name = "total_cost", nullable = false)
	private Double totalCost;
	
	@Column(name = "total_days", nullable = false)
	private Long totalDays;
	
	@Column(name = "last_update")
	private Calendar lastUpdate;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name = "showhours", nullable = false)
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
	public UserEntity getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(UserEntity createdBy) {
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
	public ProjectEntity getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(ProjectEntity project) {
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
