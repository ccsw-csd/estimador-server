package com.ccsw.estimador.cost.model;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla cost
 *
 */
public class CostDto {

    private String grade;
    private Double cost;
    private Double margin;

    public CostDto() {
    }

    public CostDto(String grade, Double cost, Double margin) {
        this();
        this.grade = grade;
        this.cost = cost;
        this.margin = margin;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the cost
     */
    public Double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * @return the margin
     */
    public Double getMargin() {
        return margin;
    }

    /**
     * @param margin the margin to set
     */
    public void setMargin(Double margin) {
        this.margin = margin;
    }

}
