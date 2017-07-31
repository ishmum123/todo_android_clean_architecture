package com.example.Implementations;

import com.example.EntityGateway;

import java.util.Date;
import java.util.List;

class TaskInteractor implements ITaskInteractor {

    private final EntityGateway gateway;

    public TaskInteractor(EntityGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public int createTask(String name, String description, Date date) {
        return gateway.createTask(name, description, date);
    }

    @Override
    public void setTaskAlarm(int checkEveryXHours) {
    }

    @Override
    public void deleteTask(int taskID) {
    }

    @Override
    public void markTaskDone(int taskID) {
    }

    @Override
    public List<ITask> getTaskList() {
        return null;
    }
}
