package com.ccsw.estimador.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.estimador.customer.model.CustomerEntity;
import com.ccsw.estimador.user.model.UserEntity;

/**
 * @author iciudade
 */
@Entity
@Table(name = "project")
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "created", nullable = false)
	private Date created;
	
	@ManyToOne
	@JoinColumn(name = "created_by", nullable = false)
	private UserEntity createdBy;
	
	@ManyToOne
	@JoinColumn(name = "customer", nullable = false)
	private CustomerEntity customer;

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
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
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
	 * @return the customer
	 */
	public CustomerEntity getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
}
