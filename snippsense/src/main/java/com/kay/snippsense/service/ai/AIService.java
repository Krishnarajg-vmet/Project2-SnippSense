package com.kay.snippsense.service.ai;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import com.kay.snippsense.entity.Snippet;

@Service
public class AIService {
	
    private final OpenAiChatModel chatModel;

    public AIService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String generateTags(String promptText) {
        Prompt prompt = new Prompt(new UserMessage(promptText));
        return chatModel.call(prompt).getResult().getOutput().getText();
    }
    
    public String autoTag(Snippet snippet) {
        String prompt = PromptBuilder.buildTagPrompt(snippet);
        return generateTags(prompt);
    }

    public String explainSnippet(Snippet snippet) {
        String prompt = PromptBuilder.buildExplanationPrompt(snippet);
        return chatModel.call(new Prompt(new UserMessage(prompt)))
                        .getResult().getOutput().getText();
    }

    public String detectLanguage(Snippet snippet) {
        String prompt = PromptBuilder.buildLanguageDetectionPrompt(snippet);
        return chatModel.call(new Prompt(new UserMessage(prompt)))
                        .getResult().getOutput().getText();
    }

}