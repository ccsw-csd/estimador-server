package com.capgemini.ccsw.estimador.taskdevelopmentweights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.elementweight.ElementWeightService;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsDto;
import com.capgemini.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         TaskDevelopmentWeightsService
 *
 */
@Service
public class TaskDevelopmentWeightsServiceImpl implements TaskDevelopmentWeightsService {

    @Autowired
    TaskDevelopmentWeightsRepository taskDevelopmentWeightsRepository;

    @Autowired
    ElementWeightService elementWeightEntity;

    @Override
    public List<TaskDevelopmentWeightsEntity> findByEstimationId(Long id) {
        return this.taskDevelopmentWeightsRepository.findByEstimationIdOrderByOrderAsc(id);
    }

    @Override
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {
        List<TaskDevelopmentWeightsEntity> actualTasks = findByEstimationId(estimation.getId());

        removeTasks(actualTasks, data.getDevelopmentTasksWeights());
        addOrModifyTasks(actualTasks, data.getDevelopmentTasksWeights(), estimation);

    }

    private void addOrModifyTasks(List<TaskDevelopmentWeightsEntity> actualTasks, List<TaskDevelopmentWeightsDto> tasks, EstimationEntity estimation) {

        for (int order = 0; order < tasks.size(); order++) {

            TaskDevelopmentWeightsDto taskDto = tasks.get(order);
            TaskDevelopmentWeightsEntity item;

            if (taskDto.getId() != null) {
                item = actualTasks.stream().filter(e -> e.getId().equals(taskDto.getId())).findFirst().orElse(null);
            } else {
                item = new TaskDevelopmentWeightsEntity();
                item.setEstimation(estimation);
            }

            item.setOrder(order);
            item.setName(taskDto.getName());

            item.setWorkElementWeight(elementWeightEntity.get(taskDto.getWorkElementWeight().getId()));
            item.setQuantityVerySimple(taskDto.getQuantityVerySimple());
            item.setQuantitySimple(taskDto.getQuantitySimple());
            item.setQuantityMedium(taskDto.getQuantityMedium());
            item.setQuantityComplex(taskDto.getQuantityComplex());
            item.setReusability(taskDto.getReusability());
            item.setHours(taskDto.getHours());
            item.setComment(taskDto.getComment());

            taskDevelopmentWeightsRepository.save(item);
        }

    }

    private void removeTasks(List<TaskDevelopmentWeightsEntity> actualTasks, List<TaskDevelopmentWeightsDto> tasks) {

        for (TaskDevelopmentWeightsEntity task : actualTasks) {
            TaskDevelopmentWeightsDto searchItem = tasks.stream().filter(e -> task.getId().equals(e.getId())).findFirst().orElse(null);

            if (searchItem == null) {
                taskDevelopmentWeightsRepository.delete(task);
            }
        }

    }

}
