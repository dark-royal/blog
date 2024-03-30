package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("comments")
public class Comment {
    @Id
    private String id;
    @DBRef
    private User commenter;
    private String comment;
}
