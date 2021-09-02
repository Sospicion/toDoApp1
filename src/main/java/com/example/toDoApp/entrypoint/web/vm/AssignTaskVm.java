package com.example.toDoApp.entrypoint.web.vm;

import lombok.Data;

@Data
public class AssignTaskVm {
    private String userId;
    private String taskId;
}
