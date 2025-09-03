package com.kay.snippsense.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tag_id")
	private Long tagId;
	
	@Column(name="tag_name", unique=true, nullable = false)
	private String tagName;
	
	@ManyToMany(mappedBy = "tags")
	private List<Snippet> snippets = new ArrayList<>();

	
	public Tag(String tagName) {
	    this.tagName = tagName;
	}
	
	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<Snippet> getSnippets() {
		return snippets;
	}

	public void setSnippets(List<Snippet> snippets) {
		this.snippets = snippets;
	}

	
	
}
