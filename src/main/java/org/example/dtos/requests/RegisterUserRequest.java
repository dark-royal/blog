package org.example.dtos.requests;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@Component
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

}
