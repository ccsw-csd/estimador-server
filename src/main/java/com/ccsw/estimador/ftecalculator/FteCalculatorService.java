package com.ccsw.estimador.ftecalculator;

import java.util.List;

import com.ccsw.estimador.criteriacalculation.model.CriteriaDto;
import com.ccsw.estimador.ftecalculator.model.FteCalculatorDto;

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
