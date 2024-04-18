package org.example.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateViewResponse {
    private String message;
    private LocalDateTime dateViewed;
}
