package com.github.todoservicewithpostgres.repository;

import com.github.todoservicewithpostgres.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
