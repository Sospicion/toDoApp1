package com.example.toDoApp.dataproviders.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String username;

    @OneToMany(mappedBy = "toDoUser")
    @JsonIgnore
    private List<toDoTask> toDoTasks;

    @Column
    @Enumerated(value = EnumType.STRING)
    private ToDoUserStatus userStatus;

}
