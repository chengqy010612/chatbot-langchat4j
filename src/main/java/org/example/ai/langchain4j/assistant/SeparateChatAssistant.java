package org.example.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT,chatMemoryProvider = "chatMemoryProvider",chatModel = "qwenChatModel",chatMemory = "chatMemory")
public interface SeparateChatAssistant {
//    @UserMessage
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @SystemMessage(fromResource = "my-prompt-template.txt")

    String chat2(@MemoryId int memoryId, @UserMessage String userMessage, @V("username")String name, @V("age") int age);
}
