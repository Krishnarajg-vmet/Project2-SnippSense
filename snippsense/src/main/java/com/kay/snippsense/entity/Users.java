package com.kay.snippsense.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long userId;
	
	@NotBlank(message = "Username is required")
	@Size(min=4, max=10)
	@Column(name="username", unique=true, nullable = false)
	private String username;
	
	@NotBlank(message="Password is Required")
	@Size(min=3)
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="fullname", nullable=false)
	private String fullname;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="last_modified")
	private LocalDateTime lastModified;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	 @PrePersist
	    protected void onCreate() {
	        this.createdAt = LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.lastModified = LocalDateTime.now();
	    }
	    
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
