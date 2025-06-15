package org.example.ai.langchain4j.service;

import org.example.ai.langchain4j.bean.ChatMessages;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository  extends MongoRepository<ChatMessages, String> {
}
