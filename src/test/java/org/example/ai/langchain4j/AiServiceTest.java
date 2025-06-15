package org.example.ai.langchain4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.example.ai.langchain4j.assistant.Assistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiServiceTest {

    @Autowired

    private OpenAiChatModel openAiChatModel;
    @Value("${DEEP_SEEK_API_KEY}")
    private String myEnvVariable;

    @Test
    public void printEnvVariable() {
        System.out.println("MY_ENV_VARIABLE: " + myEnvVariable);
    }

    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, openAiChatModel);
        String answer = assistant.chat("你是谁");
        System.out.println(answer);

    }


    @Autowired
    private Assistant assistant;

    @Test
    public void testChat2() {
        String answer = assistant.chat("你是谁");
        System.out.println(answer);
    }
}
