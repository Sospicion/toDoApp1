package com.example.toDoApp.entrypoint.service.impl;

import com.example.toDoApp.dataproviders.database.entities.ToDoPage;
import com.example.toDoApp.dataproviders.database.entities.ToDoUser;
import com.example.toDoApp.dataproviders.database.entities.toDoTask;
import org.springframework.data.domain.Page;

public interface toDoInterface {
    toDoTask createToDo(final String title, final String description);
    void changeStatus(final String id, final String markStatus);
    void updateDescription(final String description, final String id);
    void updateTitle (final String title, final String id);
    Page<toDoTask> getSavedTasks(final String status, ToDoPage toDoPage);
    toDoTask assignTask(final String userId, final String taskId);
}