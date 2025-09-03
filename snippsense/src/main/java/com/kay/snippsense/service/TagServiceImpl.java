package com.kay.snippsense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kay.snippsense.entity.Tag;
import com.kay.snippsense.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag findOrCreateTag(String name) {
        return tagRepository.findByTagNameIgnoreCase(name)
            .orElseGet(() -> tagRepository.save(new Tag(name)));
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }
}
