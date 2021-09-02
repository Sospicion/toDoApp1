package com.example.toDoApp.entrypoint.service.impl;

import com.example.toDoApp.dataproviders.database.entities.ToDoUser;

public interface ToDoUserInterface {
    ToDoUser createToDoUser(String name);
    void changeToDoUserName(String name);

}
