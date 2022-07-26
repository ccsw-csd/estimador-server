package com.ccsw.estimador.ftecalculator.model;

/**
 * @author asolerpa
 *
 *         Clase DTO de la operación de negocio calculateFte
 *
 */
public class FteCalculatorDto {

    private Double teamLeader;

    private Double manager;

    /**
     * @return teamLeader
     */
    public Double getTeamLeader() {

        return this.teamLeader;
    }

    /**
     * @param teamLeader new value of {@link #getteamLeader}.
     */
    public void setTeamLeader(Double teamLeader) {

        this.teamLeader = teamLeader;
    }

    /**
     * @return manager
     */
    public Double getManager() {

        return this.manager;
    }

    /**
     * @param manager new value of {@link #getmanager}.
     */
    public void setManager(Double manager) {

        this.manager = manager;
    }

}
