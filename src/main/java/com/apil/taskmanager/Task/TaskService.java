package com.apil.taskmanager.Task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }
    public Optional<Task> getTaskById(Long id)
    {
        return taskRepository.findById(id);
    }
    public Task saveTask(Task task)
    {
        taskRepository.save(task);
        return task;
    }
    @Transactional
    public void updateTask(Long id, Task task)
    {
        Optional<Task> taskExists = taskRepository.findById(id);
        if(taskExists.isPresent())
        {
            Task updateTask = taskExists.get();
            if(!task.getDescription().equals(updateTask.getDescription()))
            {
                updateTask.setDescription(task.getDescription());
            }
            if(!task.getName().equals(updateTask.getName()))
            {
                updateTask.setName(task.getName());
            }
            if(!task.getDueDate().equals(updateTask.getDueDate()))
            {
                updateTask.setDueDate(task.getDueDate());
            }
            if(task.isCompleted() != updateTask.isCompleted())
            {
                updateTask.setCompleted(task.isCompleted());
            }
        }
        else
        {
            throw new IllegalStateException("Task not found");
        }
    }
    public void deleteTask(Long id)
    {
        if(!taskRepository.existsById(id))
        {
            throw new IllegalStateException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}
