package com.kay.snippsense.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kay.snippsense.entity.Tag;
import com.kay.snippsense.service.TagService;

@Controller
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public String listTags(Model model) {
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags", tags);
        return "tags-list";
    }
}