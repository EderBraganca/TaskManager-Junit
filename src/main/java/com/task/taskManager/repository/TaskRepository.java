package com.task.taskManager.repository;

import com.task.taskManager.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {

    List<Task> findByCompletedFalse();
    List<Task> findByCompletedTrue();
    Task findById(int id);

}
