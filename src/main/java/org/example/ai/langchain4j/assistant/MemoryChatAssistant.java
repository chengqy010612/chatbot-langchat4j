package org.example.ai.langchain4j.assistant;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT,chatMemory = "chatMemory",chatModel = "qwenChatModel")
public interface MemoryChatAssistant {
    String chat(String userMessage);

}
