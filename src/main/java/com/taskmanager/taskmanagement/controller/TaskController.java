package com.taskmanager.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskmanager.taskmanagement.payload.TaskDto;
import com.taskmanager.taskmanagement.service.TaskServiceInterface;

@Controller
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskServiceInterface taskService;

    @PostMapping("/{userid}/task")
    public ResponseEntity<TaskDto> saveTask( @PathVariable("userid") long userId,@RequestBody TaskDto taskDto){
        return new ResponseEntity<> (taskService.saveTask(userId, taskDto),HttpStatus.CREATED);
    }

    @GetMapping("/{userid}/task")
    public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable(name="userid") long userid){
        return new ResponseEntity<>(taskService.getAllTasks(userid),HttpStatus.OK);
    }
}

