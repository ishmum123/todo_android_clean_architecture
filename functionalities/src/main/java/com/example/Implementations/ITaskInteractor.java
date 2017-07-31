package com.example.Implementations;

import com.example.Interactor;

import java.util.Date;
import java.util.List;

public interface ITaskInteractor extends Interactor {
    int createTask(String name, String description, Date date);
    void setTaskAlarm(int checkEveryXHours);
    void deleteTask(int taskID);
    void markTaskDone(int taskID);
    List<ITask> getTaskList();
}
