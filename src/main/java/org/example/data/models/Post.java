package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


    @Data
    @Document("Posts")
    public class Post {
        @Id
        private String id;
        private LocalDateTime createdAt;
        private String title;
        private String content;
        @DBRef
        private List<View> views;
        @DBRef
        private List<Comment> comments;
    }

