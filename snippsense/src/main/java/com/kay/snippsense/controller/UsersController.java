package com.kay.snippsense.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kay.snippsense.dto.UsersDto;
import com.kay.snippsense.entity.Users;
import com.kay.snippsense.service.UsersService;

@Controller
public class UsersController {
	
	private UsersService userService;
	
	UsersController (UsersService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/public/register")
    public String registerUser(@Valid @ModelAttribute("user") UsersDto userDto,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            return "user-register";
        }

        try {
            Users user = userService.toEntity(userDto);
            userService.registerUser(user);
        } catch (RuntimeException e) {
            model.addAttribute("registrationError", e.getMessage());
            return "user-register";
        }

        return "redirect:/login";
    }
	
	@GetMapping("/users/{id}")
    public String viewUserProfile(@PathVariable Long id, Model model) {
        return userService.findById(id)
                .map(user -> {
                    UsersDto userDto = userService.toDto(user);
                    model.addAttribute("user", userDto);
                    return "user-profile";
                })
                .orElse("redirect:/error");
    }

    @PostMapping("/public/reset-password")
    public String resetPassword(@RequestParam("username") String username,
                                @RequestParam("newPassword") String newPassword,
                                @RequestParam("confirmPassword") String confirmPassword,
                                Model model) {

        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "reset-password";
        }

        boolean success = userService.resetPassword(username, newPassword);

        if (!success) {
            model.addAttribute("error", "Invalid username or email.");
            return "reset-password";
        }

        model.addAttribute("success", "Password updated successfully.");
        return "reset-password";
    }

    @PostMapping("/users/update")
    public String updateUserProfile(@ModelAttribute("user") UsersDto userDto, Model model) {
        return userService.findById(userDto.getUserId())
                .map(existingUser -> {
                    try {
                        userService.validateUniqueUsername(userDto.getUsername(), existingUser.getUserId());
                        userService.updateUser(existingUser);
                        return "redirect:/users/" + existingUser.getUserId();
                    } catch (RuntimeException e) {
                        model.addAttribute("error", e.getMessage());
                        model.addAttribute("user", userDto);
                        return "user-profile";
                    }
                })
                .orElse("redirect:/error");
    }

}
