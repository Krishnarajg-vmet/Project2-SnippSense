package com.kay.snippsense.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.*;

public class UsersDto {
	
	private Long userId;
	
	@NotBlank(message="Username is required")
	private String username;
	
	@NotBlank(message="Password is required")
	private String password;
	
	@NotBlank(message="Fullname is required")
	private String fullname;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime lastModified;
	
	private Boolean isActive;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
