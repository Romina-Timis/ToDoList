package com.projectwork.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.projectwork.todolist.model.AdmUser;
import com.projectwork.todolist.service.AdmUserService;
import org.springframework.ui.Model;
import java.sql.Timestamp;
import java.time.Instant;

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

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("user", new AdmUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute AdmUser user) {
        user.setRoles("USER");
        user.setCreatedAt(Timestamp.from(Instant.now())); // Imposta la data di creazione
        // La password viene salvata in chiaro per il test
        userService.saveUser(user);
        return "redirect:/login";
    }
}
