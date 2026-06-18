package com.example.demo.service;


import com.example.demo.entity.status;
import com.example.demo.entity.task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public task createTask(task tk) {

        tk.setStatus(status.TODO);

        tk.setCreatedAt(LocalDateTime.now());

        tk.setUpdatedAt(LocalDateTime.now());

        return repository.save(tk);
    }

    @Override
    public task getTaskById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found with id : " + id));
    }

    @Override
    public task updateTask(Long id, task updatedTask) {

        task existingTask = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setDueDate(updatedTask.getDueDate());

        existingTask.setUpdatedAt(LocalDateTime.now());

        return repository.save(existingTask);
    }
    @Override
    public void deleteTask(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }

        repository.deleteById(id);
    }
    @Override
    public task completeTask(Long id) {

        task task = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        task.setStatus(status.COMPLETED);

        task.setUpdatedAt(LocalDateTime.now());

        return repository.save(task);
    }
}