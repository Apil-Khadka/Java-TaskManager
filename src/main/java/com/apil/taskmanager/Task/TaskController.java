package com.apil.taskmanager.Task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById( @PathVariable Long id)
    {
        return taskService.getTaskById(id).orElseThrow(() -> new IllegalStateException("Task not found"));
    }

    @PostMapping
    public Task createTask(@RequestBody Task task)
    {
        return taskService.saveTask(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task)
    {
        taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
    }
}
