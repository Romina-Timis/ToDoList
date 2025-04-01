package com.projectwork.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwork.todolist.model.Task;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByIdTask(int id);
}