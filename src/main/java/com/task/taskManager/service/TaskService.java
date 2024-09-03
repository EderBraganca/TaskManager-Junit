package com.task.taskManager.service;

import com.task.taskManager.domain.Task;
import com.task.taskManager.repository.TaskRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return addTask(task);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        try {
            taskRepository.findById(task.getId());
            taskRepository.delete(task);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Task task, String newName, String newDescription){
        try{
            if(!newName.isEmpty()){task.setName(newName);}
            if(!newDescription.isEmpty()){task.setDescription(newDescription);}
            taskRepository.save(task);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Task update(Task task, boolean status){
        try{
            task.setCompleted(status);
            return taskRepository.save(task);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(int id){
        return taskRepository.findById(id);
    }
}
