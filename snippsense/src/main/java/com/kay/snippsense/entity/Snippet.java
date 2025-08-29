package com.kay.snippsense.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kay.snippsense.enums.Language;

import jakarta.persistence.*;

@Entity
@Table(name="snippets")
public class Snippet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="snippet_id")
	private Long snippetId;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="code", nullable = false, length=5000)
	private String code;
	
	@Enumerated(EnumType.STRING)
	@Column(name="language", nullable = false)
	private Language language;
	
	@Column(name="project", nullable=false)
	private String project;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="snippet_tags", joinColumns = @JoinColumn(name="snippet_id"),inverseJoinColumns = @JoinColumn(name="tag_id") )
	private List<Tag> tags = new ArrayList<>();
	
	@Column(name="error_log", nullable=false, length=3000)
	private String errorLog;
	
	@Column(name="error_signature", nullable=false)
	private String errorSignature;
	
	@Column(name="ai_explanation", nullable=false, length=5000)
	private String aiExplanation;
	
	@Column(name="context_note", nullable = false, length=5000)
	private String contextNote;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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
	
	

}
