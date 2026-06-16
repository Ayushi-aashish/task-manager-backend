package com.example.demo.service;
import com.example.demo.entity.task;
import java.util.List;

public interface TaskService {

    task createTask(task T);

    List<task> getAllTasks();

    task getTaskById(Long id);

    task updateTask(Long id, task Tk);

    void deleteTask(Long id);

    task completeTask(Long id);
}
