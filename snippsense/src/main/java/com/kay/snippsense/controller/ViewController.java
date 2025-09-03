package com.kay.snippsense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kay.snippsense.dto.UsersDto;

@Controller
public class ViewController {
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/public/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/public/register")
	public String registerPage(Model model) {
	    model.addAttribute("user", new UsersDto());
	    return "user-register";
	}

	
	@GetMapping("/public/reset-password")
	public String resetPasswordPage() {
		return "reset-password";
	}
	
	@GetMapping("/api/snippets")
	public String snippetPage() {
		return "snippets";
	}
	
	
	@GetMapping("/api/users")
	public String usersPage() {
		return "users";
	}
	
	@GetMapping("/api/tags")
	public String tagsPage() {
		return "tags";
	}

}
