package org.example.ai.langchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testDashScopeQwen {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testDashScopeQwen() {
//向模型提问
        String answer = qwenChatModel.chat("你好");
//输出结果
        System.out.println(answer);
    }


}
