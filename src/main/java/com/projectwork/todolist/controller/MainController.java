package com.projectwork.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.projectwork.todolist.model.AdmUser;
import com.projectwork.todolist.service.AdmUserService;
import org.springframework.ui.Model;

@Controller
public class MainController {
    private final AdmUserService userService;

    public MainController(AdmUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "redirect:/task/all";
    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";
    }

    @GetMapping("/profilo")
    public String viewProfilo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        AdmUser user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "profilo";
    }
}
