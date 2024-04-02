package org.example.dtos.requests;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Data
@Component
public class CreatePostRequest {
    private String title;
    private String content;
    private String author;
    private LocalDateTime datePosted;


}
