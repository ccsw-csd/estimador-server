package com.capgemini.ccsw.estimador.ftecalculator;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaDto;
import com.capgemini.ccsw.estimador.ftecalculator.model.FteCalculatorDto;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz FteCalculatorService
 *
 */
@Service
public class FteCalculatorServiceImpl implements FteCalculatorService {

    private static final int WORK_DAYS = 20;

    @Override
    public FteCalculatorDto calculateFte(List<CriteriaDto> criteriaList) {

        FteCalculatorDto fteCalculatorDto = new FteCalculatorDto();
        Double manager = 0d;
        Double teamLeader = 0d;

        manager = criteriaList.stream().filter(criteria -> criteria.getBlock().getName().equals("Gestión"))
                .mapToDouble(criteria -> criteria.getValue()).sum();

        teamLeader = criteriaList.stream().filter(criteria -> criteria.getBlock().getName().equals("TeamLeader"))
                .mapToDouble(criteria -> criteria.getValue()).sum();

        fteCalculatorDto.setManager(manager / WORK_DAYS);
        fteCalculatorDto.setTeamLeader(teamLeader / WORK_DAYS);

        return fteCalculatorDto;
    }

}
