package com.projectwork.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projectwork.todolist.model.TaskAssignments;
import com.projectwork.todolist.service.TaskAssignmentsService;

@RestController
public class TaskAssignmentsController {
    @Autowired
    private TaskAssignmentsService taskAssignmentsService;

    @GetMapping("/users/{userId}/tasks")
    public List<TaskAssignments> getTasksByUserId(@PathVariable int userId) {
        return taskAssignmentsService.getTasksByUserId(userId);
    }
}
