package org.example.ai.langchain4j;

import org.example.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


@SpringBootTest
public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent( "你好1");
        chatMessages.setMemoryId(1);
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testUpdate(){
        Criteria criteria = Criteria.where("_id").is("682b32d7058b9e1d831bfb6b");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content","改变");
        mongoTemplate.upsert(query,update,ChatMessages.class);
    }
}
