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

    @Override
    public FteCalculatorDto calculateFte(List<CriteriaDto> criteriaList) {

        FteCalculatorDto fteCalculatorDto = new FteCalculatorDto();
        Double manager = 0d;
        Double teamLeader = 0d;

        for (int i = 0; i < criteriaList.size(); i++) {

            if (criteriaList.get(i).getBlock().getId() == 10) {
                manager = manager + criteriaList.get(i).getValue();
            }

            else if (criteriaList.get(i).getBlock().getId() == 20) {
                teamLeader = teamLeader + criteriaList.get(i).getValue();
            }
        }

        fteCalculatorDto.setManager(manager / 20);
        fteCalculatorDto.setTeamLeader(teamLeader / 20);

        return fteCalculatorDto;
    }

}
