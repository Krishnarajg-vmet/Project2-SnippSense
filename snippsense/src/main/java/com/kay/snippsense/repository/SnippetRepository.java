package com.kay.snippsense.repository;

import org.springframework.stereotype.Repository;

import com.kay.snippsense.entity.Snippet;
import com.kay.snippsense.entity.Users;
import com.kay.snippsense.enums.Language;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SnippetRepository extends JpaRepository<Snippet, Long> {
	
	List<Snippet> findByUserAndLanguage(Users user, Language language);
	
	List<Snippet> findByUser(Users user);
	
	List<Snippet> findByUserAndProject(Users user, String project);
	
	List<Snippet> findByUserAndErrorSignature(Users user, String errorSignature);
	
	List<Snippet> findByUserAndTags_TagName(Users user, String tagName);
	
    List<Snippet> findByTitleContainingIgnoreCaseOrErrorLogContainingIgnoreCase(String title, String errorLog);

	List<Snippet> findByTitleContainingIgnoreCase(String title);


}
