package com.ccsw.estimador.consideration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccsw.estimador.consideration.model.ConsiderationDto;
import com.ccsw.estimador.consideration.model.ConsiderationEntity;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz ConsiderationService
 *
 */
@Service
public class ConsiderationServiceImpl implements ConsiderationService {

    @Autowired
    ConsiderationRepository considerationRepository;

    @Override
    public List<ConsiderationEntity> findByEstimationId(Long id) {

        return this.considerationRepository.findByEstimationIdOrderByOrderAsc(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {
        List<ConsiderationEntity> actualConsiderations = findByEstimationId(estimation.getId());

        removeTasks(actualConsiderations, data.getConsiderations());
        addOrModifyTasks(actualConsiderations, data.getConsiderations(), estimation);

    }

    private void addOrModifyTasks(List<ConsiderationEntity> actualConsiderations, List<ConsiderationDto> considerations, EstimationEntity estimation) {

        for (int order = 0; order < considerations.size(); order++) {

            ConsiderationDto considerationDto = considerations.get(order);
            ConsiderationEntity item;

            if (considerationDto.getId() != null) {
                item = actualConsiderations.stream().filter(e -> e.getId().equals(considerationDto.getId())).findFirst().orElse(null);
            } else {
                item = new ConsiderationEntity();
                item.setEstimation(estimation);
            }

            item.setOrder(order);
            item.setComment(considerationDto.getComment());

            considerationRepository.save(item);
        }

    }

    private void removeTasks(List<ConsiderationEntity> actualConsiderations, List<ConsiderationDto> considerations) {

        for (ConsiderationEntity item : actualConsiderations) {
            ConsiderationDto searchItem = considerations.stream().filter(e -> item.getId().equals(e.getId())).findFirst().orElse(null);

            if (searchItem == null) {
                considerationRepository.delete(item);
            }
        }

    }
}
