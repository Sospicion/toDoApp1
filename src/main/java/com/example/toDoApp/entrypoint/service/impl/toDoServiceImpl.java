package com.example.toDoApp.entrypoint.service.impl;

import com.example.toDoApp.dataproviders.database.entities.Status;
import com.example.toDoApp.dataproviders.database.entities.ToDoPage;
import com.example.toDoApp.dataproviders.database.entities.ToDoUser;
import com.example.toDoApp.dataproviders.database.entities.toDoTask;
import com.example.toDoApp.dataproviders.database.repositories.ToDoUserRepository;
import com.example.toDoApp.dataproviders.database.repositories.toDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class toDoServiceImpl implements toDoInterface{

    private final toDoRepository todorepository;
    private final ToDoUserRepository toDoUserRepository;


    @Override
    public toDoTask createToDo(final String title, final String description) {
        final toDoTask entity = toDoTask.builder()
                .description(description)
                .title(title)
                .creationDate(Instant.now())
                .status(Status.INCOMPLETE)
                .build();
        return todorepository.save(entity);

    }

    @Override
    public void changeStatus(String id, String status) {
        todorepository.getById(Long.valueOf(id)).setStatus(Status.valueOf(status));
        todorepository.save(todorepository.getById(Long.valueOf(id)));

    }

    @Override
    public void updateDescription(String description, String id) {
        todorepository.getById(Long.valueOf(id)).setDescription(description);
        todorepository.save(todorepository.getById(Long.valueOf(id)));


    }

    @Override
    public void updateTitle(String title, String id) {
        todorepository.getById(Long.valueOf(id)).setTitle(title);
        todorepository.save(todorepository.getById(Long.valueOf(id)));


    }

    @Override
    public Page<toDoTask> getSavedTasks(String status, ToDoPage toDoPage) {
        Sort sort = Sort.by(toDoPage.getSortDirection(),toDoPage.getSortBy());
        Pageable pageable = PageRequest.of(toDoPage.getPageNumber(),
                toDoPage.getPageSize(),sort);

        switch (status){
            case "EXPIRED":
                return todorepository.findByStatus(Status.valueOf(status),pageable);
            case "COMPLETE":
                return todorepository.findByStatus(Status.valueOf(status),pageable);
            case "INCOMPLETE":
                return todorepository.findByStatus(Status.valueOf(status),pageable);
            case "PENDING":
                return todorepository.findByStatus(Status.valueOf(status),pageable);
            default:
                return todorepository.findAll(pageable);
                }

    }

    @Override
    public toDoTask assignTask(String userId, String taskId) {
        todorepository.getById(Long.valueOf(taskId)).setToDoUser(toDoUserRepository.getById(Long.valueOf(userId)));
        todorepository.getById(Long.valueOf(taskId)).setStatus(Status.ASSIGNED);
        return todorepository.save(todorepository.getById(Long.valueOf(taskId)));


    }
}
