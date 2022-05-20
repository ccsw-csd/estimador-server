package com.capgemini.ccsw.estimador.gradeworkdayscalculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.gradeworkdayscalculator.model.GradeWorkDaysCalculatorDto;
import com.capgemini.ccsw.estimador.gradeworkdayscalculator.model.GradeWorkDaysCalculatorTransformatedDto;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         GradeWorkDaysCalculatorService
 *
 */
@Service
public class GradeWorkDaysCalculatorServiceImpl implements GradeWorkDaysCalculatorService {

    @Override
    public List<GradeWorkDaysCalculatorTransformatedDto> calculateWorkDaysPerGrade(
            List<GradeWorkDaysCalculatorDto> gradeWorkDaysCalculatorList) {

        List<GradeWorkDaysCalculatorTransformatedDto> transformedDtoList = new ArrayList<>();
        GradeWorkDaysCalculatorTransformatedDto transformatedDtoGradeA = new GradeWorkDaysCalculatorTransformatedDto();
        GradeWorkDaysCalculatorTransformatedDto transformatedDtoGradeB = new GradeWorkDaysCalculatorTransformatedDto();
        GradeWorkDaysCalculatorTransformatedDto transformatedDtoGradeC = new GradeWorkDaysCalculatorTransformatedDto();
        GradeWorkDaysCalculatorTransformatedDto transformatedDtoGradeD = new GradeWorkDaysCalculatorTransformatedDto();
        Double gradeA = 0d, gradeB = 0d, gradeC = 0d, gradeD = 0d;

        gradeA = gradeWorkDaysCalculatorList.stream().mapToDouble(row -> row.getGradeA() / 100 * row.getWorkdays())
                .sum();
        transformatedDtoGradeA.setGrade("A");
        transformatedDtoGradeA.setWorkdays(gradeA);
        transformedDtoList.add(transformatedDtoGradeA);

        gradeB = gradeWorkDaysCalculatorList.stream().mapToDouble(row -> row.getGradeB() / 100 * row.getWorkdays())
                .sum();
        transformatedDtoGradeB.setGrade("B");
        transformatedDtoGradeB.setWorkdays(gradeB);
        transformedDtoList.add(transformatedDtoGradeB);

        gradeC = gradeWorkDaysCalculatorList.stream().mapToDouble(row -> row.getGradeC() / 100 * row.getWorkdays())
                .sum();
        transformatedDtoGradeC.setGrade("C");
        transformatedDtoGradeC.setWorkdays(gradeC);
        transformedDtoList.add(transformatedDtoGradeC);

        gradeD = gradeWorkDaysCalculatorList.stream().mapToDouble(row -> row.getGradeD() / 100 * row.getWorkdays())
                .sum();
        transformatedDtoGradeD.setGrade("D");
        transformatedDtoGradeD.setWorkdays(gradeD);
        transformedDtoList.add(transformatedDtoGradeD);

        return transformedDtoList;
    }

}
