package org.example.ai.langchain4j;

import org.example.ai.langchain4j.assistant.Assistant;
import org.example.ai.langchain4j.assistant.MemoryChatAssistant;
import org.example.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatMemoryTest {
    @Autowired
    private Assistant assistant;

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testChatMemory() {
        String answer1 = separateChatAssistant.chat(1,"我是cheng");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(1,"我是谁");
        System.out.println(answer2);


//        String answer22 = separateChatAssistant.chat(2,"我是谁");
//        System.out.println(answer22);
    }


    @Test
    public void testChatMemoryArg() {
        String name = "cheng2";
        int age = 18;

        String answer1 = separateChatAssistant.chat2(1,"你是谁",name,age);
        System.out.println(answer1);
    }

    @Test
    public void testChatMemory2() {
        String answer1 = memoryChatAssistant.chat("我是cheng");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("我是谁");
        System.out.println(answer2);
    }
}