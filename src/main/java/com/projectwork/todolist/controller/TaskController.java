package com.projectwork.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectwork.todolist.service.TaskService;

import org.springframework.web.bind.annotation.GetMapping;

import com.projectwork.todolist.model.Task;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getAllTask(Model model) {
        List<Task> task = taskService.getAllTask();
        if (task == null || task.isEmpty()) {
            model.addAttribute("errorMessage", "Nessun task disponibile al momento.");
        } else {
            model.addAttribute("task", task);
        }
        return "index";
    }

}
