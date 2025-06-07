package com.taskmanager.taskmanagement.servicelmplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanagement.entity.Task;
import com.taskmanager.taskmanagement.entity.User;
import com.taskmanager.taskmanagement.exceptions.UserNotFound;
import com.taskmanager.taskmanagement.payload.TaskDto;
import com.taskmanager.taskmanagement.repository.UserRepository;
import com.taskmanager.taskmanagement.repository.TaskRepository;
import com.taskmanager.taskmanagement.service.TaskServiceInterface;

@Service
public class TaskServiceImpl implements TaskServiceInterface{
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TaskRepository taskRepository;
 
    @Override
    public TaskDto saveTask(long userId, TaskDto taskDto) {
        User user= userRepository.findById(userId).orElseThrow(
            () -> new UserNotFound(String.format("User Id %s is not found", userId))
        );
        Task task=modelMapper.map(taskDto,Task.class);
        task.setUsers(user);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask,TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(long userid) {
          userRepository.findById(userid).orElseThrow(
            () -> new UserNotFound(String.format("User Id %s is not found", userid))
        );
        List<Task> tasks = taskRepository.findAllByUserId(userid);

        return tasks.stream().map(
            task -> modelMapper.map(task,TaskDto.class)
        ).collect(Collectors.toList());
    }
    
}
