package com.ccsw.estimador.taskdevelopmenthours.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla task_hour
 *
 */
@Entity
@Table(name = "task_hour")
public class TaskDevelopmentHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estimation_id", nullable = false)
    private EstimationEntity estimation;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "reusability")
    private Double reusability;

    @Column(name = "hours")
    private Double hours;

    @Column(name = "comment")
    private String comment;

    @Column(name = "`order`")
    private Integer order;

    /**
     * @return the order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

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
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name new value of {@link #getname}.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return quantity
     */
    public Double getQuantity() {
        return this.quantity;
    }

    /**
     * @param quantity new value of {@link #getquantity}.
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return reusability
     */
    public Double getReusability() {
        return this.reusability;
    }

    /**
     * @param reusability new value of {@link #getreusability}.
     */
    public void setReusability(Double reusability) {
        this.reusability = reusability;
    }

    /**
     * @return hours
     */
    public Double getHours() {
        return this.hours;
    }

    /**
     * @param hours new value of {@link #gethours}.
     */
    public void setHours(Double hours) {
        this.hours = hours;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @param comment new value of {@link #getcomment}.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
