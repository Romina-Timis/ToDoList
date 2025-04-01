package com.projectwork.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectwork.todolist.service.TaskService;



@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService taskService;

   
    
}
