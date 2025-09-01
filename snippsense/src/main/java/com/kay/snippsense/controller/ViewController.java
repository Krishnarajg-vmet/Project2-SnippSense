package com.kay.snippsense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
