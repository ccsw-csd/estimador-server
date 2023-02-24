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
    private Double revenue;
    private Double workdays;

    public CostDto() {
    }

    public CostDto(String grade, Double cost, Double margin) {
        this();
        this.grade = grade;
        this.cost = cost;
        this.margin = margin;
    }
    public CostDto(String grade, Double cost, Double margin, Double revenue, Double workdays) {
        this();
        this.grade = grade;
        this.cost = cost;
        this.margin = margin;
        this.revenue =  revenue;
        this.workdays = workdays;
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

    /**
     * @return the revenue
     */
    public Double getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    /**
     * @return the workdays
     */
    public Double getWorkdays() {
        return workdays;
    }

    /**
     * @param workdays the workdays to set
     */
    public void setWorkdays(Double workdays) {
        this.workdays = workdays;
    }

}
