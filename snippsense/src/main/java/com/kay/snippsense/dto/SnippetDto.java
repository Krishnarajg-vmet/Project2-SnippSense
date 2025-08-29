package com.kay.snippsense.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kay.snippsense.entity.Tag;
import com.kay.snippsense.entity.Users;
import com.kay.snippsense.enums.Language;

public class SnippetDto {
	
	
	private Long snippetId;
	
	private String title;
	
	private String code;
	
	private Language language;
	
	private String project;
	
	private List<Tag> tags = new ArrayList<>();
	
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
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
