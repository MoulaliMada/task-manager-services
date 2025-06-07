package com.taskmanager.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanagement.entity.User;
import com.taskmanager.taskmanagement.payload.UserDto;
import com.taskmanager.taskmanagement.service.UserServiceInterface;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserServiceInterface userService;
    // using POST save the user in DB 
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
    }
}
