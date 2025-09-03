package com.kay.snippsense.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kay.snippsense.dto.SnippetDto;
import com.kay.snippsense.entity.Snippet;
import com.kay.snippsense.service.SnippetService;

@Controller
@RequestMapping("/snippets")
public class SnippetController {

    private final SnippetService snippetService;

    public SnippetController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }
    
    @GetMapping
    public String listSnippets(Model model) {
        List<Snippet> snippets = snippetService.getAllSnippets();
        model.addAttribute("snippets", snippets);
        return "snippets-list";
    }
 
    @GetMapping("/{id}")
    public String viewSnippet(@PathVariable Long id, Model model) {
        Snippet snippet = snippetService.getSnippetById(id);
        model.addAttribute("snippet", snippet);
        return "snippets-view";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("snippetDto", new SnippetDto());
        return "snippets-create";
    }

    @PostMapping
    public String createSnippet(@ModelAttribute SnippetDto snippetDto) {
        snippetService.createSnippet(snippetDto);
        return "redirect:/snippets";
    }

    @GetMapping("/search")
    public String searchSnippets(@RequestParam("query") String query, Model model) {
        List<Snippet> results = snippetService.searchByTitle(query);
        model.addAttribute("snippets", results);
        return "snippets-list";
    }
}