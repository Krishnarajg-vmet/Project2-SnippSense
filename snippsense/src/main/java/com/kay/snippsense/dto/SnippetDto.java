package com.kay.snippsense.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kay.snippsense.entity.Tag;
import com.kay.snippsense.entity.Users;
import com.kay.snippsense.enums.Language;

import jakarta.validation.constraints.NotBlank;

public class SnippetDto {
	
	
	private Long snippetId;
	
	@NotBlank(message="Title is required")
	private String title;
	
	@NotBlank(message="Code is required")
	private String code;
	
	@NotBlank(message="Language is required")
	private Language language;
	
	@NotBlank(message="Project is required")
	private String project;
	
	private List<String> tags = new ArrayList<>();
	
	private String errorLog;
	
	private String errorSignature;
	
	private String aiExplanation;
	
	private String contextNote;
	
	private LocalDateTime createdAt;
	
	private Users user;

	public Long getSnippetId() {
		return snippetId;
	}

	public void setSnippetId(Long snippetId) {
		this.snippetId = snippetId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}


	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getErrorLog() {
		return errorLog;
	}

	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	public String getErrorSignature() {
		return errorSignature;
	}

	public void setErrorSignature(String errorSignature) {
		this.errorSignature = errorSignature;
	}

	public String getAiExplanation() {
		return aiExplanation;
	}

	public void setAiExplanation(String aiExplanation) {
		this.aiExplanation = aiExplanation;
	}

	public String getContextNote() {
		return contextNote;
	}

	public void setContextNote(String contextNote) {
		this.contextNote = contextNote;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	

}
