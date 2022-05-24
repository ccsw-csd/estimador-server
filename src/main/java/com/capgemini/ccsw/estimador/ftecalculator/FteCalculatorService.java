package com.capgemini.ccsw.estimador.ftecalculator;

import java.util.List;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaDto;
import com.capgemini.ccsw.estimador.ftecalculator.model.FteCalculatorDto;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio relacionadas con
 *         calculos de Fte
 *
 */
public interface FteCalculatorService {

    FteCalculatorDto calculateFte(List<CriteriaDto> criteriaList);
}
