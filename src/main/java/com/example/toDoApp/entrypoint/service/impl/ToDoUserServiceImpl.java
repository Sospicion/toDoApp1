package com.example.toDoApp.entrypoint.service.impl;


import com.example.toDoApp.dataproviders.database.entities.ToDoUser;
import com.example.toDoApp.dataproviders.database.entities.ToDoUserStatus;
import com.example.toDoApp.dataproviders.database.repositories.ToDoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoUserServiceImpl implements ToDoUserInterface {

    private final ToDoUserRepository toDoUserRepository;

    @Override
    public ToDoUser createToDoUser(String name) {
        final ToDoUser entity = ToDoUser.builder()
                .username(name)
                .userStatus(ToDoUserStatus.ACTIVE)
                .build();

        return toDoUserRepository.save(entity);
    }

    @Override
    public void changeToDoUserName(String name) {

    }
}
