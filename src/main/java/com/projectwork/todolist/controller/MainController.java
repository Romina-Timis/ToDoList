package com.projectwork.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String homePage() {

		return "redirect:/task/all";
	}

	@GetMapping("/login")
	public String viewLogin() {

		return "login";
	}

}
