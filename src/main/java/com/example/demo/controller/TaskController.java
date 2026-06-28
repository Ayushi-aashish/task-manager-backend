package com.example.demo.controller;

import com.example.demo.dto.CreateTaskRequest;
import com.example.demo.dto.TaskResponseRequest;
import com.example.demo.dto.UpdateTaskRequest;
import com.example.demo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
    public TaskResponseRequest createTask(@Valid @RequestBody CreateTaskRequest request) {
        return taskService.createTask(request);
    }

    /**
     * Get all tasks
     * GET /tasks
     */
    @GetMapping
    public Page<TaskResponseRequest> getAllTasks(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size) {

        return taskService.getAllTasks(page, size);
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
            @PathVariable Long id,@Valid
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