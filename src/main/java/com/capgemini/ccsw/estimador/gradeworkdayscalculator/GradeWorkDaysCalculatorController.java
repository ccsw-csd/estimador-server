package com.capgemini.ccsw.estimador.gradeworkdayscalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.gradeworkdayscalculator.model.GradeWorkDaysCalculatorDto;
import com.capgemini.ccsw.estimador.gradeworkdayscalculator.model.GradeWorkDaysCalculatorTransformatedDto;

/**
 * @author asolerpa
 *
 *         Controlador que expone las operaciones para calcular las jornadas
 *         totales por grados
 *
 */
@RestController
@RequestMapping(value = "/gradeworkdayscalculator")
public class GradeWorkDaysCalculatorController {

    @Autowired
    GradeWorkDaysCalculatorService gradeWorkDaysCalculatorService;

    @RequestMapping(path = "/calculate")
    public List<GradeWorkDaysCalculatorTransformatedDto> calculateWorkDaysPerGrade(
            @RequestBody List<GradeWorkDaysCalculatorDto> gradeWorkDaysCalculatorList) {
        return this.gradeWorkDaysCalculatorService.calculateWorkDaysPerGrade(gradeWorkDaysCalculatorList);
    }

}
