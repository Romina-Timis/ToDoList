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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.projectwork.todolist.model.AdmUser;
import com.projectwork.todolist.service.AdmUserService;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private AdmUserService userService;

    @GetMapping("/all")
    public String getAllTask(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        AdmUser user = userService.findByUsername(username);

        List<Task> task = taskService.getTasksByUser(user);
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

    @GetMapping("/add")
    public String showAddTaskForm() {
        return "add-task";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        AdmUser user = userService.findByUsername(username);

        task.setCreatedBy(user);
        task.setStatus(Task.Status.TODO); // Default status
        taskService.saveTask(task);

        return "redirect:/task/all";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteById(id);
        return "redirect:/task/all";
    }

}
