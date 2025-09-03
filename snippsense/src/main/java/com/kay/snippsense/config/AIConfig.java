package com.kay.snippsense.config;

import org.springframework.ai.model.tool.ToolCallingManager;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

import io.micrometer.observation.ObservationRegistry;

@Configuration
public class AIConfig {
	
    @Bean
    public OpenAiChatModel openAiChatModel(
            OpenAiApi openAiApi,
            ToolCallingManager toolCallingManager,
            RetryTemplate retryTemplate,
            ObservationRegistry observationRegistry) {
        return OpenAiChatModel.builder()
                .openAiApi(openAiApi)
                .defaultOptions(OpenAiChatOptions.builder()
                    .model("gpt-4o")
                    .temperature(0.4)
                    .build())
                .toolCallingManager(toolCallingManager)
                .retryTemplate(retryTemplate)
                .observationRegistry(observationRegistry)
                .build();
    }

}
