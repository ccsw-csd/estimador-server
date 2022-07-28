package com.ccsw.estimador.elementweight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.elementweight.model.ElementWeightDto;
import com.ccsw.estimador.elementweight.model.ElementWeightEntity;
import com.ccsw.estimador.estimation.EstimationService;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.estimationlevel.EstimationLevelService;
import com.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsDto;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz ElementWeightService
 *
 */
@Service
public class ElementWeightServiceImpl implements ElementWeightService {

    @Autowired
    ElementWeightRepository elementWeightRepository;

    @Autowired
    EstimationService estimationService;

    @Autowired
    EstimationLevelService estimationLevelService;

    @Override
    public List<ElementWeightEntity> findByEstimationId(Long id) {

        return this.elementWeightRepository.findByEstimationId(id);
    }

    @Override
    public List<ElementWeightEntity> findByEstimationCustomer(CustomerDto customer) {

        return this.elementWeightRepository.findByEstimationId(this.estimationService.getLastEstimationByCustomer(customer).getId());

    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {

        List<ElementWeightEntity> actualWeight = findByEstimationId(estimation.getId());

        removeWeights(actualWeight, data.getElementWeight());
        addOrModifyWeights(actualWeight, data, estimation);

    }

    @Override
    public ElementWeightEntity get(Long id) {
        return elementWeightRepository.findById(id).orElse(null);
    }

    private void addOrModifyWeights(List<ElementWeightEntity> actualWeights, EstimationEditDto data, EstimationEntity estimation) {

        List<ElementWeightDto> weights = data.getElementWeight();
        for (ElementWeightDto weightDto : weights) {

            ElementWeightEntity item = null;

            if (weightDto.getId() != null) {
                item = actualWeights.stream().filter(e -> e.getId().equals(weightDto.getId())).findFirst().orElse(null);
            }

            if (item == null) {
                item = new ElementWeightEntity();
                item.setEstimation(estimation);
            }

            item.setElement(weightDto.getElement());
            item.setVerySimple(weightDto.getVerySimple());
            item.setSimple(weightDto.getSimple());
            item.setMedium(weightDto.getMedium());
            item.setComplex(weightDto.getComplex());
            item.setLevel(estimationLevelService.get(weightDto.getLevel().getId()));

            elementWeightRepository.save(item);

            if (weightDto.getId() != null && weightDto.getId().longValue() < 0) {
                remapElementWeightId(data.getDevelopmentTasksWeights(), weightDto.getId(), item.getId());
            }
        }

    }

    private void remapElementWeightId(List<TaskDevelopmentWeightsDto> tasks, Long oldId, Long newId) {

        for (TaskDevelopmentWeightsDto task : tasks) {

            if (oldId.equals(task.getWorkElementWeight().getId())) {
                task.getWorkElementWeight().setId(newId);
            }
        }

    }

    private void removeWeights(List<ElementWeightEntity> actualWeights, List<ElementWeightDto> weights) {

        for (ElementWeightEntity weight : actualWeights) {
            ElementWeightDto searchItem = weights.stream().filter(e -> weight.getId().equals(e.getId())).findFirst().orElse(null);

            if (searchItem == null) {
                elementWeightRepository.delete(weight);
            }
        }
    }

}
