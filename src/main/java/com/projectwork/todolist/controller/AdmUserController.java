package com.projectwork.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectwork.todolist.model.AdmUser;
import com.projectwork.todolist.service.AdmUserService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/users")
public class AdmUserController {

    private final AdmUserService userService;

    public AdmUserController(AdmUserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public List<AdmUser> getAllUsers(){
        return userService.getAllUsers();
    }

    

}