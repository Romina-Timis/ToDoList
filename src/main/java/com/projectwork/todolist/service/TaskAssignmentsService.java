package com.projectwork.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectwork.todolist.model.TaskAssignments;
import com.projectwork.todolist.repository.TaskAssignmentsRepository;

@Service
public class TaskAssignmentsService {
    @Autowired
    private TaskAssignmentsRepository taskAssignmentsRepository;

    public List<TaskAssignments> getAllTask() {
        return taskAssignmentsRepository.findAll();
    }

    public List<TaskAssignments> getTasksByUserId(int userId) {
        return taskAssignmentsRepository.findByUserId(userId);
    }
}
