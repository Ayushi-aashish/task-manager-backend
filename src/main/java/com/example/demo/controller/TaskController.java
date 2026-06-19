package com.example.demo.controller;

import com.example.demo.dto.CreateTaskRequest;
import com.example.demo.dto.TaskResponseRequest;
import com.example.demo.dto.UpdateTaskRequest;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Create a new task
     * POST /tasks
     */
    @PostMapping
    public TaskResponseRequest createTask(@RequestBody CreateTaskRequest request) {
        return taskService.createTask(request);
    }

    /**
     * Get all tasks
     * GET /tasks
     */
    @GetMapping
    public List<TaskResponseRequest> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Get task by ID
     * GET /tasks/{id}
     */
    @GetMapping("/{id}")
    public TaskResponseRequest getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    /**
     * Update a task
     * PUT /tasks/{id}
     */
    @PutMapping("/{id}")
    public TaskResponseRequest updateTask(
            @PathVariable Long id,
            @RequestBody UpdateTaskRequest request) {

        return taskService.updateTask(id, request);
    }

    /**
     * Delete a task
     * DELETE /tasks/{id}
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    /**
     * Mark task as completed
     * PATCH /tasks/{id}/complete
     */
    @PatchMapping("/{id}/complete")
    public TaskResponseRequest completeTask(@PathVariable Long id) {
        return taskService.completeTask(id);
    }
}