package com.ccsw.estimador.ftecalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.estimador.criteriacalculation.model.CriteriaDto;
import com.ccsw.estimador.ftecalculator.model.FteCalculatorDto;

/**
 * @author asolerpa
 *
 *         Controlador que expone las operaciones para calcular los valores de
 *         Fte
 *
 */
@RestController
@RequestMapping(value = "/ftecalculator")
public class FteCalculatorController {

    @Autowired
    FteCalculatorService fteCalculatorService;

    @RequestMapping(path = "/calculate", method = RequestMethod.POST)
    public FteCalculatorDto calculateFte(@RequestBody List<CriteriaDto> criteriaList) {

        return this.fteCalculatorService.calculateFte(criteriaList);
    }
}
