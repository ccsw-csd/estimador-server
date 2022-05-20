package com.capgemini.ccsw.estimador.gradeworkdayscalculator;

import java.util.List;

import com.capgemini.ccsw.estimador.gradeworkdayscalculator.model.GradeWorkDaysCalculatorDto;
import com.capgemini.ccsw.estimador.gradeworkdayscalculator.model.GradeWorkDaysCalculatorTransformatedDto;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio relacionadas con
 *         calculos de jornadas totales por grados
 *
 */
public interface GradeWorkDaysCalculatorService {

    List<GradeWorkDaysCalculatorTransformatedDto> calculateWorkDaysPerGrade(
            List<GradeWorkDaysCalculatorDto> gradeWorkDaysCalculatorList);

}
