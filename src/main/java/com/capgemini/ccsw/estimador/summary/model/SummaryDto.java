package com.capgemini.ccsw.estimador.summary.model;

import com.capgemini.ccsw.estimador.block.model.BlockDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;

/**
 * @author asolerpa
 *
 *         Clase DTO de la entidad SummaryEntity
 *
 */
public class SummaryDto {

    private Long id;

    private EstimationDto estimation;

    private BlockDto block;

    private Double a;

    private Double b;

    private Double c;

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
    public EstimationDto getEstimation() {

        return this.estimation;
    }

    /**
     * @param estimation new value of {@link #getestimation}.
     */
    public void setEstimation(EstimationDto estimation) {

        this.estimation = estimation;
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
