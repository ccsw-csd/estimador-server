package com.ccsw.estimador.estimation.model;

import java.sql.Date;

import org.springframework.data.domain.Pageable;

/**
 * @author iciudade
 */
public class EstimationSearchDto {

	private Pageable pageable;
	
	private Long customerId;
	
	private String projectName;
	
	private Date startDate;
	
	private Date endDate;

	/**
	 * @return the pageable
	 */
	public Pageable getPageable() {
		return pageable;
	}

	/**
	 * @param pageable the pageable to set
	 */
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
}