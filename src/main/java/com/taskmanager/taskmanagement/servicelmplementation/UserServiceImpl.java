package com.taskmanager.taskmanagement.servicelmplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanagement.entity.User;
import com.taskmanager.taskmanagement.payload.UserDto;
import com.taskmanager.taskmanagement.repository.UserRepository;
import com.taskmanager.taskmanagement.service.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=userDtoToEntity(userDto); //convert user dto to user class(entity)
        User savedUser = userRepository.save(user);
        return entityToUserDto(savedUser);
    }

    private User userDtoToEntity(UserDto userDto){
       User user=new User();
       user.setName(userDto.getName());
       user.setEmail(userDto.getEmail());
       user.setPassword(userDto.getPassword());
       return user;
    }
    
    private UserDto entityToUserDto(User savedUser){
        UserDto userDto=new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setName(savedUser.getName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setPassword(savedUser.getPassword());
        return userDto;
    }
   
    
}
