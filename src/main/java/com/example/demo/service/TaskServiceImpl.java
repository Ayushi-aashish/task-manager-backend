package com.example.demo.service;

import com.example.demo.dto.CreateTaskRequest;
import com.example.demo.dto.TaskResponseRequest;
import com.example.demo.dto.TaskResponseRequest;
import com.example.demo.dto.UpdateTaskRequest;
import com.example.demo.entity.*;
import com.example.demo.Mapper.TaskMapper;
import com.example.demo.exception.ResourceNotFoundException;
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
    public TaskResponseRequest createTask(CreateTaskRequest request) {

        // Convert DTO -> Entity
        task task = TaskMapper.toEntity(request);

        // Business Rules
        task.setStatus(status.TODO);

        if (task.getPriority() == null) {
            task.setPriority(priority.MEDIUM);
        }

        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        // Save
        task savedTask = repository.save(task);

        // Convert Entity -> DTO
        return TaskMapper.toResponse(savedTask);
    }

    @Override
    public List<TaskResponseRequest> getAllTasks() {

        List<task> tasks = repository.findAll();

        return TaskMapper.toResponseList(tasks);
    }

    @Override
    public TaskResponseRequest getTaskById(Long id) {

        task task = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id);

        return TaskMapper.toResponse(task);
    }

    @Override
    public TaskResponseRequest updateTask(Long id, UpdateTaskRequest request) {

        task existingTask = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found with id: " + id));

        // Update only editable fields
        existingTask.setTitle(request.getTitle());
        existingTask.setDescription(request.getDescription());
        existingTask.setPriority(request.getPriority());
        existingTask.setDueDate(request.getDueDate());

        existingTask.setUpdatedAt(LocalDateTime.now());

        task updatedTask = repository.save(existingTask);

        return TaskMapper.toResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public TaskResponseRequest completeTask(Long id) {

        task task = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task Not Found"));

        task.setStatus(status.COMPLETED);
        task.setUpdatedAt(LocalDateTime.now());

        task completedTask = repository.save(task);

        return TaskMapper.toResponse(completedTask);
    }
}