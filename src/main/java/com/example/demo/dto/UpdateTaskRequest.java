
package com.example.demo.dto;

import com.example.demo.entity.priority;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;


@Getter
@Setter
public class UpdateTaskRequest {

    @NotBlank(message = "the title should not be blank")
    @Size(max = 100,message = "The size should not exceed 100 characters")
    private String title;

    @Size(max=500,message="The size should not exceed characters")
    private String description;

    private priority priority;

    @FutureOrPresent(message="Due date cannot be in the past")
    private LocalDate dueDate;
}