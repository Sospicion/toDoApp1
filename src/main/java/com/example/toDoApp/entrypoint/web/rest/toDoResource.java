package com.example.toDoApp.entrypoint.web.rest;

import com.example.toDoApp.dataproviders.database.entities.ToDoPage;
import com.example.toDoApp.dataproviders.database.entities.toDoTask;
import com.example.toDoApp.dataproviders.database.repositories.toDoRepository;
import com.example.toDoApp.entrypoint.service.impl.toDoInterface;
import com.example.toDoApp.entrypoint.web.vm.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/todo")
public class toDoResource {
    private final toDoInterface todointerface;
    private final toDoRepository todorepository;

    public toDoResource(toDoInterface todointerface, toDoRepository todorepository) {
        this.todointerface = todointerface;
        this.todorepository = todorepository;
    }

    @PostMapping(path = "/change-status")
    public ResponseEntity<toDoTask> changeStatus(@RequestBody changeStatusVm changestatusvm){
       todointerface.changeStatus(changestatusvm.getId(), changestatusvm.getStatus());
       return ResponseEntity.ok(todorepository.getById(Long.valueOf(changestatusvm.getId())));
    }


    @PostMapping(path = "/add")
    public ResponseEntity<toDoTask> createToDo(@RequestBody toDoVm todovm){
        toDoTask entity = todointerface.createToDo(todovm.getTitle(), todovm.getDesc());
        return ResponseEntity.ok(entity);
    }

    @PostMapping(path = "/change-description")
    public ResponseEntity<toDoTask> updateDescription(@RequestBody updateDescriptionVm updatedescriptionvm){
        todointerface.updateDescription(updatedescriptionvm.getDescription(),updatedescriptionvm.getId());
        return ResponseEntity.ok(todorepository.getById(Long.valueOf(updatedescriptionvm.getId())));
    }

    @PostMapping(path = "/change-title")
    public ResponseEntity<toDoTask> updateTitle(@RequestBody updateTitleVm updatetitlevm){
        todointerface.updateTitle(updatetitlevm.getTitle(),updatetitlevm.getId());
        return ResponseEntity.ok(todorepository.getById(Long.valueOf(updatetitlevm.getId())));

    }

    @PostMapping(path = "/get-tasks-by-status")
    public ResponseEntity<Page<toDoTask>> getSavedTasks(@RequestBody getSavedTasksVm getsavedtasksvm, ToDoPage toDoPage){
        return ResponseEntity.ok(todointerface.getSavedTasks(getsavedtasksvm.getStatus(),toDoPage));

    }

    @PostMapping(path = "/assign-task")
    public ResponseEntity<toDoTask> assignTask(@RequestBody AssignTaskVm assignTaskVm){
        return ResponseEntity.ok(todointerface.assignTask(assignTaskVm.getUserId(),assignTaskVm.getTaskId()));
    }
}
