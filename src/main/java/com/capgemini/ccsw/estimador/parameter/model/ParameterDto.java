package com.capgemini.ccsw.estimador.parameter.model;

import com.capgemini.ccsw.estimador.block.model.BlockDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad ParameterEntity
 *
 */
public class ParameterDto {

    private Long id;

    private BlockDto block;

    private String concept;

    private Double value;

    private String type;

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
     * @return block
     */
    public BlockDto getBlock() {

        return this.block;
    }

    /**
     * @param block new value of {@link #getblock}.
     */
    public void setBlock(BlockDto block) {

        this.block = block;
    }

    /**
     * @return concept
     */
    public String getConcept() {

        return this.concept;
    }

    /**
     * @param concept new value of {@link #getconcept}.
     */
    public void setConcept(String concept) {

        this.concept = concept;
    }

    /**
     * @return value
     */
    public Double getValue() {

        return this.value;
    }

    /**
     * @param value new value of {@link #getvalue}.
     */
    public void setValue(Double value) {

        this.value = value;
    }

    /**
     * @return type
     */
    public String getType() {

        return this.type;
    }

    /**
     * @param type new value of {@link #gettype}.
     */
    public void setType(String type) {

        this.type = type;
    }

}
