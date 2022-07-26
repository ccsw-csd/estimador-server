package com.ccsw.estimador.taskdevelopmenthours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursDto;
import com.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         TaskDevelopmentHoursService
 *
 */
@Service
public class TaskDevelopmentHoursServiceImpl implements TaskDevelopmentHoursService {

    @Autowired
    TaskDevelopmentHoursRepository taskDevelopmentHoursRepository;

    @Override
    public List<TaskDevelopmentHoursEntity> findByEstimationId(Long id) {
        return this.taskDevelopmentHoursRepository.findByEstimationIdOrderByOrderAsc(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {
        List<TaskDevelopmentHoursEntity> actualTasks = findByEstimationId(estimation.getId());

        removeTasks(actualTasks, data.getDevelopmentTasksHours());
        addOrModifyTasks(actualTasks, data.getDevelopmentTasksHours(), estimation);

    }

    private void addOrModifyTasks(List<TaskDevelopmentHoursEntity> actualTasks, List<TaskDevelopmentHoursDto> tasks, EstimationEntity estimation) {

        for (int order = 0; order < tasks.size(); order++) {

            TaskDevelopmentHoursDto taskDto = tasks.get(order);
            TaskDevelopmentHoursEntity item;

            if (taskDto.getId() != null) {
                item = actualTasks.stream().filter(e -> e.getId().equals(taskDto.getId())).findFirst().orElse(null);
            } else {
                item = new TaskDevelopmentHoursEntity();
                item.setEstimation(estimation);
            }

            item.setOrder(order);
            item.setName(taskDto.getName());
            item.setQuantity(taskDto.getQuantity());
            item.setHours(taskDto.getHours());
            item.setReusability(taskDto.getReusability());
            item.setComment(taskDto.getComment());

            taskDevelopmentHoursRepository.save(item);
        }

    }

    private void removeTasks(List<TaskDevelopmentHoursEntity> actualTasks, List<TaskDevelopmentHoursDto> tasks) {

        for (TaskDevelopmentHoursEntity task : actualTasks) {
            TaskDevelopmentHoursDto searchItem = tasks.stream().filter(e -> task.getId().equals(e.getId())).findFirst().orElse(null);

            if (searchItem == null) {
                taskDevelopmentHoursRepository.delete(task);
            }
        }

    }
}
