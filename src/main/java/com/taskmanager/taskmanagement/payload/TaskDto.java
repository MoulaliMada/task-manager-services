package com.taskmanager.taskmanagement.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private long id;
    private String taskName;
}
