package com.example.demo.repository;
import com.example.demo.entity.task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<task,Long> {

}
