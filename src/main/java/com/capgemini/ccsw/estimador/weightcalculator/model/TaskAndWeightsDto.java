package com.capgemini.ccsw.estimador.weightcalculator.model;

import java.util.List;

public class TaskAndWeightsDto {

    List<TaskDto> tasks;

    List<WeightsDto> weights;

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

    public List<WeightsDto> getWeights() {
        return weights;
    }

    public void setWeights(List<WeightsDto> weights) {
        this.weights = weights;
    }
}
