package com.kay.snippsense.service;

import java.util.List;

import com.kay.snippsense.dto.SnippetDto;
import com.kay.snippsense.entity.Snippet;

public interface SnippetService {

	Snippet createSnippet(SnippetDto dto);
    List<Snippet> getAllSnippets();
    Snippet getSnippetById(Long id);
    List<Snippet> searchByTitle(String title);
    
}
