package com.example.toDoApp.entrypoint.web.rest;


import com.example.toDoApp.dataproviders.database.entities.ToDoUser;
import com.example.toDoApp.dataproviders.database.repositories.ToDoUserRepository;
import com.example.toDoApp.entrypoint.service.impl.ToDoUserInterface;
import com.example.toDoApp.entrypoint.web.vm.CreateUserVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/todo/user")
public class ToDoUserResource {

    private final ToDoUserRepository toDoUserRepository;
    private final ToDoUserInterface toDoUserInterface;

    public ToDoUserResource(ToDoUserRepository toDoUserRepository, ToDoUserInterface toDoUserInterface) {
        this.toDoUserRepository = toDoUserRepository;
        this.toDoUserInterface = toDoUserInterface;
    }


    @PostMapping(path = "/add-user")
    public ResponseEntity<ToDoUser> createUser(@RequestBody CreateUserVm createUserVm){
        ToDoUser entity= toDoUserInterface.createToDoUser(createUserVm.getUsername());
        return ResponseEntity.ok(entity);
    }

}
