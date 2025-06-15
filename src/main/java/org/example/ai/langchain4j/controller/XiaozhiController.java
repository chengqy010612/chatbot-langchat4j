package org.example.ai.langchain4j.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.ai.langchain4j.assistant.XiaozhiAgent;
import org.example.ai.langchain4j.bean.ChatForm;
import org.example.ai.langchain4j.bean.ChatMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@Tag(name = "xx助手")
@RestController
@RequestMapping("/xiaozhi")
public class XiaozhiController {
    @Autowired
    private XiaozhiAgent xiaozhiAgent;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Operation(summary = "对话 ")
    @PostMapping(value= "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm) {
        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }


    @Operation(summary = "对话列表 ")
    @GetMapping(value= "/chatList")
    public List<ChatMessages> chat() {
        List<ChatMessages> allChatMessages = mongoTemplate.findAll(ChatMessages.class);

        return allChatMessages;
    }
}
