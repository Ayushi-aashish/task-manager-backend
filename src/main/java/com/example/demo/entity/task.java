package com.example.demo.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Task")
public class task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private priority Priority;
    @Enumerated(EnumType.STRING)
    private status Status;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDate updatedAt;




}
