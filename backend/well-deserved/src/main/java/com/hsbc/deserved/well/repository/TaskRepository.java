package com.hsbc.deserved.well.repository;

import com.hsbc.deserved.well.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}