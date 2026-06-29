package com.example.demo.repository;
import com.example.demo.entity.priority;
import com.example.demo.entity.status;
import com.example.demo.entity.task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<task,Long> {


    List<task> findByStatus(status status);

    List<task> findByPriority(priority priority);

    List<task> findByTitleContainingIgnoreCase(String title);

}
