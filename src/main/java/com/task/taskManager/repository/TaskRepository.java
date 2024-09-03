package com.task.taskManager.repository;

import com.task.taskManager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByCompletedFalse();
    List<Task> findByCompletedTrue();
    Task findById(int id);
}
