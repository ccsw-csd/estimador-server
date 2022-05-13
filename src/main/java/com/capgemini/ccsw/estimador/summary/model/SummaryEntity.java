package com.capgemini.ccsw.estimador.summary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.ccsw.estimador.block.model.BlockEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla summary
 *
 */
@Entity
@Table(name = "summary")
public class SummaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estimation")
    private EstimationEntity estimation;

    @ManyToOne
    @JoinColumn(name = "block")
    private BlockEntity block;

    @Column(name = "a")
    private Double a;

    @Column(name = "b")
    private Double b;

    @Column(name = "c")
    private Double c;

    @Column(name = "d")
    private Double d;

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
     * @return a
     */
    public Double getA() {

        return this.a;
    }

    /**
     * @param a new value of {@link #geta}.
     */
    public void setA(Double a) {

        this.a = a;
    }

    /**
     * @return b
     */
    public Double getB() {

        return this.b;
    }

    /**
     * @param b new value of {@link #getb}.
     */
    public void setB(Double b) {

        this.b = b;
    }

    /**
     * @return c
     */
    public Double getC() {

        return this.c;
    }

    /**
     * @param c new value of {@link #getc}.
     */
    public void setC(Double c) {

        this.c = c;
    }

    /**
     * @return d
     */
    public Double getD() {

        return this.d;
    }

    /**
     * @param d new value of {@link #getd}.
     */
    public void setD(Double d) {

        this.d = d;
    }

}
