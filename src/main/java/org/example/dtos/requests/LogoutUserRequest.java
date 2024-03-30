package org.example.dtos.requests;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LogoutUserRequest {
    private String username;
}
