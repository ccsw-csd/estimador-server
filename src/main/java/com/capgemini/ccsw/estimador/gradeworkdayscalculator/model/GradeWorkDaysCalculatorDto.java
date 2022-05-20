package com.capgemini.ccsw.estimador.gradeworkdayscalculator.model;

import com.capgemini.ccsw.estimador.block.model.BlockDto;

/**
 * @author asolerpa
 *
 *         Clase DTO que recibe la operación de negocio
 *         calculateWorkDaysPerGrade
 *
 */
public class GradeWorkDaysCalculatorDto {

    private BlockDto block;

    private Double workdays;

    private Double gradeA;

    private Double gradeB;

    private Double gradeC;

    private Double gradeD;

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
     * @return workdays
     */
    public Double getWorkdays() {
        return this.workdays;
    }

    /**
     * @param workdays new value of {@link #getworkdays}.
     */
    public void setWorkdays(Double workdays) {
        this.workdays = workdays;
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
