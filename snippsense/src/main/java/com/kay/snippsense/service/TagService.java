package com.kay.snippsense.service;

import java.util.List;

import com.kay.snippsense.entity.Tag;

public interface TagService {
	Tag findOrCreateTag(String tagName);
    List<Tag> findAll();
}
