package com.ccsw.estimador.parameter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.estimador.block.model.BlockEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla parameter
 *
 */
@Entity
@Table(name = "parameter")
public class ParameterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "block")
    private BlockEntity block;

    @Column(name = "concept")
    private String concept;

    @Column(name = "val")
    private Double value;

    @Column(name = "comment")
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
    public BlockEntity getBlock() {

        return this.block;
    }

    /**
     * @param block new value of {@link #getblock}.
     */
    public void setBlock(BlockEntity block) {

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
