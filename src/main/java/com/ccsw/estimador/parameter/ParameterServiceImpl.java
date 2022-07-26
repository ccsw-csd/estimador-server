package com.ccsw.estimador.parameter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccsw.estimador.block.BlockService;
import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.estimationparameter.EstimationParameterService;
import com.ccsw.estimador.estimationparameter.model.EstimationParameterEntity;
import com.ccsw.estimador.parameter.model.ParameterDto;
import com.ccsw.estimador.parameter.model.ParameterEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz ParameterService
 *
 */
@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    EstimationParameterService estimationParameterService;

    @Autowired
    BlockService blockService;

    @Override
    public List<ParameterEntity> findParametersByEstimationId(Long id) {
        List<ParameterEntity> parameters = new ArrayList();

        List<EstimationParameterEntity> list = this.estimationParameterService.findParametersByEstimationId(id);

        list.forEach(element -> {
            parameters.add(element.getParameter());
        });

        return parameters;
    }

    @Override
    public List<ParameterEntity> findParametersByEstimationCustomer(CustomerDto customer) {

        List<ParameterEntity> parameters = new ArrayList();

        List<EstimationParameterEntity> list = this.estimationParameterService.findParametersByEstimationCustomer(customer);

        list.forEach(element -> {
            parameters.add(element.getParameter());
        });

        return parameters;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {

        List<EstimationParameterEntity> actualParameters = this.estimationParameterService.findParametersByEstimationId(estimation.getId());

        removeParameters(actualParameters, data.getParameters());
        addOrModifyParameters(actualParameters, data.getParameters(), estimation);

    }

    private void addOrModifyParameters(List<EstimationParameterEntity> actualParameters, List<ParameterDto> parameters, EstimationEntity estimation) {

        for (ParameterDto parameterDto : parameters) {

            EstimationParameterEntity estimationParameter;

            if (parameterDto.getId() != null) {
                estimationParameter = actualParameters.stream().filter(e -> e.getParameter().getId().equals(parameterDto.getId())).findFirst().orElse(null);
            } else {
                estimationParameter = new EstimationParameterEntity();
                estimationParameter.setEstimation(estimation);
                estimationParameter.setParameter(new ParameterEntity());
            }

            estimationParameter.getParameter().setBlock(blockService.get(parameterDto.getBlock().getId()));
            estimationParameter.getParameter().setConcept(parameterDto.getConcept());
            estimationParameter.getParameter().setValue(parameterDto.getValue());
            estimationParameter.getParameter().setType(parameterDto.getType());

            parameterRepository.save(estimationParameter.getParameter());
            estimationParameterService.save(estimationParameter);
        }

    }

    private void removeParameters(List<EstimationParameterEntity> actualParameters, List<ParameterDto> parameters) {

        for (EstimationParameterEntity parameter : actualParameters) {
            ParameterDto searchParameter = parameters.stream().filter(e -> parameter.getParameter().getId().equals(e.getId())).findFirst().orElse(null);

            if (searchParameter == null) {
                parameterRepository.delete(parameter.getParameter());
            }
        }
    }

}
