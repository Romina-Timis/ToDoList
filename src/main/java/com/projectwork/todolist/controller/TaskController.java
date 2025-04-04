package com.projectwork.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectwork.todolist.service.TaskService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.projectwork.todolist.model.Task;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public String getAllTask(Model model) {
        List<Task> task = taskService.getAllTask();
        if (task == null || task.isEmpty()) {
            model.addAttribute("errorMessage", "Nessun task disponibile al momento.");
        } else {
            model.addAttribute("task", task);
        }
        return "index";
    }

    @GetMapping("/status/{status}")
    public String getTasksByStatus(@PathVariable String status, Model model) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        if (tasks == null || tasks.isEmpty()) {
            model.addAttribute("errorMessage", "Nessun task trovato con lo stato: " + status);
        } else {
            model.addAttribute("tasks", tasks);
        }
        return "index"; 
    }

    @GetMapping("/{id}/edit")
    public String editTask(@PathVariable Integer id, Model model) {
        Task task = taskService.getById(id).orElseThrow(() -> new IllegalArgumentException("Task non trovato"));
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Integer id, @ModelAttribute Task updatedTask) {
        Task task = taskService.getById(id).orElseThrow(() -> new IllegalArgumentException("Task non trovato"));
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());
        taskService.saveTask(task); // Corretto il nome del metodo
        return "redirect:/task/all";
    }

}
