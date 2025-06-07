package com.taskmanager.taskmanagement.service;

import java.util.List;

import com.taskmanager.taskmanagement.payload.TaskDto;

public interface TaskServiceInterface {
    public TaskDto saveTask(long userId,TaskDto taskDto);
    public List<TaskDto> getAllTasks(long userid);
}
