package com.projectwork.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "home"; // Carica home.html
    }

    @GetMapping("/logout")
    public String logout() {
    return "redirect:/"; // Torna alla pagina di login
}
}