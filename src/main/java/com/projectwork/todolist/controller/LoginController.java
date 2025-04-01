package com.projectwork.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projectwork.todolist.service.UserService;


@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        @RequestParam(value = "email", required = false) String email,
                        @RequestParam(value = "password", required = false) String password,
                        Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Credenziali non valide. Riprova.");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Logout effettuato con successo.");
        }
        if (email != null && password != null) {
            var user = userService.findByEmailAndPassword(email, password);
            if (user.isPresent()) {
                model.addAttribute("successMessage", "Login effettuato con successo.");
                return "redirect:/"; // Redirect to the home page
            } else {
                model.addAttribute("errorMessage", "Email o password errati.");
            }
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}