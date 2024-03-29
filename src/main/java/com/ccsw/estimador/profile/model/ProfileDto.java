package com.ccsw.estimador.profile.model;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad ProfileEntity
 *
 */
public class ProfileDto {

    private Long id;

    private String name;

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

}
