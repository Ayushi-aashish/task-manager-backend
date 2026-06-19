
package com.example.demo.dto;

import com.example.demo.entity.priority;
import com.example.demo.entity.status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

    @Getter
    @Setter
    public class TaskResponseRequest {

        private Long id;

        private String title;

        private String description;

        private status status;

        private priority priority;

        private LocalDate dueDate;

        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;
    }

