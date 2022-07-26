package com.ccsw.estimador.taskarchitecture.model;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad TaskArchitectureEntity
 *
 */
public class TaskArchitectureDto {

    private Long id;

    private String name;

    private Double hours;

    private String comment;

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
