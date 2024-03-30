package org.example.dtos.responses;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class RegisterUserResponse {
    private DateTimeFormatter date;
    private String username;
    @Id
    private String id;
}
