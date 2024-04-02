package org.example.utils;

import org.example.data.models.Post;
import org.example.data.models.User;
import org.example.dtos.requests.CreatePostRequest;
import org.example.dtos.requests.FindEntryRequest;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.dtos.responses.CreatePostResponse;
import org.example.dtos.responses.FindPostResponse;
import org.example.dtos.responses.RegisterUserResponse;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest){
        User user = new User();
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        return user;

    }

    public static RegisterUserResponse map(User save){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(save.getId());
        registerUserResponse.setUsername(save.getUsername());
        registerUserResponse.setDate(DateTimeFormatter.ofPattern(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now())));
        return registerUserResponse;
    }

    public static CreatePostResponse map(Post createPost){
        CreatePostResponse createPostResponse = new CreatePostResponse();
        createPostResponse.setTitle(createPost.getTitle());
        createPostResponse.setContent(createPost.getContent());
        return createPostResponse;
    }

    public static Post map(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setContent(createPostRequest.getContent());
        return post;
    }


}
