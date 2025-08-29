package com.kay.snippsense.dto;

import java.util.ArrayList;
import java.util.List;

import com.kay.snippsense.entity.Snippet;

public class TagDto {
	
	private Long tagId;
	
	private String tagName;
	
	private List<Snippet> snippets = new ArrayList<>();

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
