package com.kay.snippsense.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kay.snippsense.dto.SnippetDto;
import com.kay.snippsense.entity.Snippet;
import com.kay.snippsense.entity.Tag;
import com.kay.snippsense.repository.SnippetRepository;

import jakarta.transaction.Transactional;

@Service
public class SnippetServiceImpl implements SnippetService {

	private final SnippetRepository snippetRepository;
    private final TagService tagService;

    public SnippetServiceImpl(SnippetRepository snippetRepository, TagService tagService) {
        this.snippetRepository = snippetRepository;
        this.tagService = tagService;
    }

    @Override
    @Transactional
    public Snippet createSnippet(SnippetDto dto) {
        Snippet snippet = new Snippet();
        snippet.setTitle(dto.getTitle());
        snippet.setCode(dto.getCode());
        snippet.setLanguage(dto.getLanguage());
        snippet.setProject(dto.getProject());
        snippet.setErrorLog(dto.getErrorLog());
        snippet.setErrorSignature(dto.getErrorSignature());
        snippet.setAiExplanation(dto.getAiExplanation());
        snippet.setContextNote(dto.getContextNote());
        snippet.setCreatedAt(LocalDateTime.now());

        List<Tag> tags = dto.getTags().stream()
        	    .map(tagService::findOrCreateTag)
        	    .collect(Collectors.toList());

        return snippetRepository.save(snippet);
    }

    @Override
    public List<Snippet> getAllSnippets() {
        return snippetRepository.findAll();
    }

    @Override
    public Snippet getSnippetById(Long id) {
        return snippetRepository.findById(id).orElseThrow(() -> new RuntimeException("Snippet not found"));
    }

    @Override
    public List<Snippet> searchByTitle(String title) {
        return snippetRepository.findByTitleContainingIgnoreCase(title);
    }
    
}
