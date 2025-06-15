package org.example.ai.langchain4j.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("chat_messages")
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessages {
    @Id
    private ObjectId messageId;

    private int memoryId;

    private  String content;
}
