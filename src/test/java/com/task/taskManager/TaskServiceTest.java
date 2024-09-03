package com.task.taskManager;

import com.task.taskManager.domain.Task;
import com.task.taskManager.repository.TaskRepository;
import com.task.taskManager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class TaskServiceTest {
    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    void setup() {
        openMocks(this);
    }

    @Test
    public void testAddTask() {
        System.out.print("Test Add: ");

        Task task = taskService.createTask("New Task", "desc", false);
        when(taskRepository.save(task)).thenReturn(task);
        Task savedTask = taskService.addTask(task);

        assertEquals("New Task", savedTask.getName());
        assertFalse(savedTask.isCompleted());

        System.out.println("OK");
    }

    @Test
    public void testRemoveTask() {
        System.out.print("Test Remove: ");

        Task task = taskService.createTask("New Task", "desc", false);

        doNothing().when(taskRepository).deleteById(task.getId());
        assertDoesNotThrow(() -> taskService.deleteTask(task));

        System.out.println("OK");
    }

    @Test
    public void testUpdateTask() {
        System.out.print("Test Update: ");
        Task task = taskService.createTask("New Task", "desc", false);
        when(taskRepository.save(task)).thenReturn(task);

        taskService.update(task, true);

        assertEquals("New Task", task.getName());
        assertTrue(task.isCompleted());

        System.out.println("OK");
    }

    @Test
    public void testFindAllTasks() {
        System.out.print("Test FindAll: ");

        Task task = taskService.createTask("New Task", "desc", false);
        Task task2 = taskService.createTask("New Task2", "desc2", false);
        Task task3 = taskService.createTask("New Task3", "desc3", false);

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task, task2, task3));
        List<Task> tasks = taskService.getAllTasks();

        assertEquals(3, tasks.size());

        System.out.println("OK");
    }

    @Test
    public void testFindTaskById() {
        System.out.print("Test FindTaskById: ");

        Task task = taskService.createTask("New Task", "desc", false);

        when(taskRepository.findById(task.getId())).thenReturn(task);

        Task searchedTask = taskService.getTaskById(task.getId());

        assertEquals("New Task", searchedTask.getName());
        assertFalse(searchedTask.isCompleted());

        System.out.println("OK");
    }
}
