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

    private Double gradeA;

    private Double gradeB;

    private Double gradeC;

    private Double gradeD;

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
     * @return gradeA
     */
    public Double getGradeA() {

        return this.gradeA;
    }

    /**
     * @param gradeA new value of {@link #getgradeA}.
     */
    public void setGradeA(Double gradeA) {

        this.gradeA = gradeA;
    }

    /**
     * @return gradeB
     */
    public Double getGradeB() {

        return this.gradeB;
    }

    /**
     * @param gradeB new value of {@link #getgradeB}.
     */
    public void setGradeB(Double gradeB) {

        this.gradeB = gradeB;
    }

    /**
     * @return gradeC
     */
    public Double getGradeC() {

        return this.gradeC;
    }

    /**
     * @param gradeC new value of {@link #getgradeC}.
     */
    public void setGradeC(Double gradeC) {

        this.gradeC = gradeC;
    }

    /**
     * @return gradeD
     */
    public Double getGradeD() {

        return this.gradeD;
    }

    /**
     * @param gradeD new value of {@link #getgradeD}.
     */
    public void setGradeD(Double gradeD) {

        this.gradeD = gradeD;
    }

}
