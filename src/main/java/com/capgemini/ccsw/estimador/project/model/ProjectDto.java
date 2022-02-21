package com.capgemini.ccsw.estimador.project.model;

import java.util.Calendar;

import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.user.model.UserDto;

/**
 * 
 * @author iciudade
 *
 */
public class ProjectDto {

	private Long id;
	
	private String name;
	
	private Calendar created;
	
	private UserDto createdBy;
	
	private CustomerDto customer;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the customer
	 */
	public CustomerDto getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

}
