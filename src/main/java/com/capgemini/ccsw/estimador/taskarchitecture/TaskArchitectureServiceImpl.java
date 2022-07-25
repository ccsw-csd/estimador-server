package com.capgemini.ccsw.estimador.taskarchitecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.taskarchitecture.model.TaskArchitectureDto;
import com.capgemini.ccsw.estimador.taskarchitecture.model.TaskArchitectureEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         TaskArchitectureService
 *
 */
@Service
public class TaskArchitectureServiceImpl implements TaskArchitectureService {

    @Autowired
    TaskArchitectureRepository taskArchitectureRepository;

    @Override
    public List<TaskArchitectureEntity> findByEstimationId(Long id) {
        return this.taskArchitectureRepository.findByEstimationIdOrderByOrderAsc(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {

        List<TaskArchitectureEntity> actualTasks = findByEstimationId(estimation.getId());

        removeTasks(actualTasks, data.getArchitectureTasks());
        addOrModifyTasks(actualTasks, data.getArchitectureTasks(), estimation);

    }

    private void addOrModifyTasks(List<TaskArchitectureEntity> actualTasks, List<TaskArchitectureDto> tasks, EstimationEntity estimation) {

        for (int order = 0; order < tasks.size(); order++) {

            TaskArchitectureDto taskDto = tasks.get(order);
            TaskArchitectureEntity item;

            if (taskDto.getId() != null) {
                item = actualTasks.stream().filter(e -> e.getId().equals(taskDto.getId())).findFirst().orElse(null);
            } else {
                item = new TaskArchitectureEntity();
                item.setEstimation(estimation);
            }

            item.setOrder(order);
            item.setName(taskDto.getName());
            item.setHours(taskDto.getHours());
            item.setComment(taskDto.getComment());

            taskArchitectureRepository.save(item);
        }

    }

    private void removeTasks(List<TaskArchitectureEntity> actualTasks, List<TaskArchitectureDto> tasks) {

        for (TaskArchitectureEntity task : actualTasks) {
            TaskArchitectureDto searchItem = tasks.stream().filter(e -> task.getId().equals(e.getId())).findFirst().orElse(null);

            if (searchItem == null) {
                taskArchitectureRepository.delete(task);
            }
        }

    }

}
