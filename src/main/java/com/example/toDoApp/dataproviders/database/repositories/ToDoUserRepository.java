package com.example.toDoApp.dataproviders.database.repositories;


import com.example.toDoApp.dataproviders.database.entities.ToDoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ToDoUserRepository extends JpaRepository<ToDoUser, Long> {
}
