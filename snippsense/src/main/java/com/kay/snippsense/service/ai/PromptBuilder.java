package com.kay.snippsense.service.ai;

import com.kay.snippsense.entity.Snippet;
import com.kay.snippsense.enums.Language;

public class PromptBuilder {

    public static String buildTagPrompt(Snippet snippet) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Analyze the following code snippet and suggest 3 to 5 relevant tags.\n\n");
        appendCommonSnippetDetails(prompt, snippet);
        prompt.append("\nReturn tags as a comma-separated list. Do not explain.");
        return prompt.toString();
    }

    public static String buildExplanationPrompt(Snippet snippet) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Explain the following code snippet, focusing on what it does and what might be wrong.\n\n");
        appendCommonSnippetDetails(prompt, snippet);

        if (snippet.getErrorLog() != null && !snippet.getErrorLog().isBlank()) {
            prompt.append("\n\nError log:\n");
            prompt.append(snippet.getErrorLog());
        }

        prompt.append("\n\nProvide a concise explanation.");
        return prompt.toString();
    }

    public static String buildLanguageDetectionPrompt(Snippet snippet) {
        return "Identify the programming language of the following code snippet:\n\n"
                + snippet.getCode()
                + "\n\nRespond with only the language name.";
    }

    public static String buildContextNotePrompt(Snippet snippet) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a short context note to help a developer remember when and why to reuse this code snippet.\n");
        appendCommonSnippetDetails(prompt, snippet);
        prompt.append("\n\nMake it 1-2 sentences. Don't explain the code, just focus on use-case context.");
        return prompt.toString();
    }

    private static void appendCommonSnippetDetails(StringBuilder builder, Snippet snippet) {
        builder.append("Title: ").append(snippet.getTitle()).append("\n");

        if (snippet.getLanguage() != null && snippet.getLanguage() != Language.OTHERS) {
            builder.append("Language: ").append(snippet.getLanguage()).append("\n");
        }

        builder.append("Project: ").append(snippet.getProject()).append("\n");
        builder.append("Code:\n").append(snippet.getCode());
    }
}
