package com.capgemini.ccsw.estimador.gradeworkdayscalculator.model;

/**
 * @author asolerpa
 *
 *         Clase DTO que envía la operación de negocio calculateWorkDaysPerGrade
 *
 */
public class GradeWorkDaysCalculatorTransformatedDto {

    private String grade;

    private Double workdays;

    /**
     * @return grade
     */
    public String getGrade() {
        return this.grade;
    }

    /**
     * @param grade new value of {@link #getgrade}.
     */
    public void setGrade(String grade) {
        this.grade = grade;
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

}
