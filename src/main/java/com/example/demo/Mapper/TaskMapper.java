package com.example.demo.Mapper;
import com.example.demo.dto.CreateTaskRequest;
import com.example.demo.dto.TaskResponseRequest;
import com.example.demo.entity.task;

import java.util.List;

public class TaskMapper {

    // Convert CreateTaskRequest -> task Entity
    public static task toEntity(CreateTaskRequest request) {

        task task = new task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        return task;
    }

    // Convert task Entity -> taskResponse
    public static TaskResponseRequest toResponse(task task) {

        TaskResponseRequest response = new TaskResponseRequest();

        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setStatus(task.getStatus());
        response.setPriority(task.getPriority());
        response.setDueDate(task.getDueDate());
        response.setCreatedAt(task.getCreatedAt());
        response.setUpdatedAt(task.getUpdatedAt());

        return response;
    }

    // Convert List<task> -> List<taskResponse>
    public static List<TaskResponseRequest> toResponseList(List<task> tasks) {

        return tasks.stream()
                .map(TaskMapper::toResponse)
                .toList();
    }
}