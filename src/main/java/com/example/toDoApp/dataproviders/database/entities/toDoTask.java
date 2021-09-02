package com.example.toDoApp.dataproviders.database.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class toDoTask implements Serializable {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="task_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Column(name="task_description")
    private String description;

    @Column(name = "task_title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "Assigned_to_user_id")
    private ToDoUser toDoUser;

    @Column
    private Instant creationDate;




}
