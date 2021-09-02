package com.example.toDoApp.dataproviders.database.repositories;

import com.example.toDoApp.dataproviders.database.entities.Status;
import com.example.toDoApp.dataproviders.database.entities.toDoTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;


@Component
public interface toDoRepository extends PagingAndSortingRepository<toDoTask, Long> {
    Page<toDoTask> findByStatus(Status status, Pageable pageable);
    toDoTask getById(Long id);

    @Override
    Page<toDoTask> findAll(Pageable pageable);
}
