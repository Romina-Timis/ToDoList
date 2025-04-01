package com.projectwork.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectwork.todolist.model.TaskAssignments;

@Repository
public interface TaskAssignmentsRepository extends JpaRepository<TaskAssignments, Integer> {
    List<TaskAssignments> findByUserId(int userId);
}
