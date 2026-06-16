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
}
