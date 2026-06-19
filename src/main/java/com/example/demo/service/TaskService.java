package com.example.demo.service;
import com.example.demo.dto.CreateTaskRequest;
import com.example.demo.dto.TaskResponseRequest;
import com.example.demo.dto.UpdateTaskRequest;
import com.example.demo.entity.task;
import java.util.List;

public interface TaskService {

    TaskResponseRequest createTask(CreateTaskRequest T);

    List<TaskResponseRequest> getAllTasks();

    TaskResponseRequest getTaskById(Long id);


    TaskResponseRequest updateTask(Long id, UpdateTaskRequest  Tk);

    void deleteTask(Long id);


    TaskResponseRequest  completeTask(Long id);
}
