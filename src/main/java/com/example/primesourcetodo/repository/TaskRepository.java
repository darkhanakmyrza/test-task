package com.example.primesourcetodo.repository;

import com.example.primesourcetodo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
