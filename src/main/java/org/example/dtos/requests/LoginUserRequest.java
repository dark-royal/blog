package org.example.dtos.requests;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoginUserRequest {

    private String username;
    private String password;

}
