package com.projectwork.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectwork.todolist.model.User;
import com.projectwork.todolist.service.UserService;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Credenziali non valide. Riprova.");
        }
        return "login";
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model) {
        Optional<User> user = userService.findByEmailAndPassword(email, password);

        if (user.isPresent()) {
            // Login riuscito, reindirizza alla home page o dashboard
            return "redirect:/index";
        } else {
            // Login fallito, mostra un messaggio di errore
            model.addAttribute("errorMessage", "Email o password errati.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}