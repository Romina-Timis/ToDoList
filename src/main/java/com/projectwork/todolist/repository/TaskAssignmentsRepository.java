package com.projectwork.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectwork.todolist.model.TaskAssignments;
import com.projectwork.todolist.model.User;

@Repository
public interface TaskAssignmentsRepository extends JpaRepository<TaskAssignments, Integer> {
    List<TaskAssignments> findByUser(User user);
    List<TaskAssignments> findByTask_IdTask(int idTask); // Updated to camelCase
}
