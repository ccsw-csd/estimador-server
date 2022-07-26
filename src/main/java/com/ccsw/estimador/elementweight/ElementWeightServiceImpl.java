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
        addOrModifyWeights(actualWeight, data.getElementWeight(), estimation);

    }

    @Override
    public ElementWeightEntity get(Long id) {
        return elementWeightRepository.findById(id).orElse(null);
    }

    private void addOrModifyWeights(List<ElementWeightEntity> actualWeights, List<ElementWeightDto> weights, EstimationEntity estimation) {

        for (ElementWeightDto weightDto : weights) {

            ElementWeightEntity item;

            if (weightDto.getId() != null) {
                item = actualWeights.stream().filter(e -> e.getId().equals(weightDto.getId())).findFirst().orElse(null);
            } else {
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
