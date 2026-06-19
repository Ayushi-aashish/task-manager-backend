package com.example.demo.dto;

import com.example.demo.entity.priority;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateTaskRequest {

    private String title;

    private String description;

    private priority priority;

    private LocalDate dueDate;
}