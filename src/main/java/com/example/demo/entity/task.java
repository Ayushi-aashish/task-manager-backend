package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Task")
public class task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
