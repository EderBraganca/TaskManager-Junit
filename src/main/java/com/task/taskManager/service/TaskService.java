package com.task.taskManager.service;

import com.task.taskManager.domain.Task;
import com.task.taskManager.repository.TaskRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TaskService{

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String name, String description, boolean completed){
        try{
            Task task = new Task();
            task.setName(name);
            task.setDescription(description);
            task.setCompleted(completed);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return taskRepository.save(task);
    }

    public void deleteTask(Task task){
        try {
            taskRepository
        }
    }

    public void updateTask(Task task){

    }

}
