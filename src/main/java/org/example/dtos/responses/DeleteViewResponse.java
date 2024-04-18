package org.example.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DeleteViewResponse {
    private String message;
    private LocalDateTime dateDeleted;
}
