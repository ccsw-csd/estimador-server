package com.capgemini.ccsw.estimador.cost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.estimador.cost.model.CostDto;
import com.capgemini.ccsw.estimador.cost.model.CostEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz CostService
 *
 */
@Service
public class CostServiceImpl implements CostService {

    @Autowired
    CostRepository costRepository;

    @Override
    public CostEntity getByEstimationId(Long estimationId) {
        return this.costRepository.getByEstimationId(estimationId);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {

        CostEntity cost = getByEstimationId(estimation.getId());

        if (cost == null) {
            cost = new CostEntity();
            cost.setEstimation(estimation);
        }

        cost.setCostGradeA(getCost(data.getCosts(), "A"));
        cost.setCostGradeB(getCost(data.getCosts(), "B"));
        cost.setCostGradeC(getCost(data.getCosts(), "C"));
        cost.setCostGradeD(getCost(data.getCosts(), "D"));

        cost.setMarginGradeA(getMargin(data.getCosts(), "A"));
        cost.setMarginGradeB(getMargin(data.getCosts(), "B"));
        cost.setMarginGradeC(getMargin(data.getCosts(), "C"));
        cost.setMarginGradeD(getMargin(data.getCosts(), "D"));

        costRepository.save(cost);
    }

    private Double getCost(List<CostDto> costs, String grade) {

        CostDto searchItem = getCostDto(costs, grade);

        if (searchItem != null)
            return searchItem.getCost();
        else
            return 0.0D;
    }

    private Double getMargin(List<CostDto> costs, String grade) {

        CostDto searchItem = getCostDto(costs, grade);

        if (searchItem != null)
            return searchItem.getMargin();
        else
            return 0.0D;
    }

    private CostDto getCostDto(List<CostDto> costs, String grade) {

        return costs.stream().filter(e -> grade.equals(e.getGrade())).findFirst().orElse(null);
    }

}
