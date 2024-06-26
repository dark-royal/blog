package org.example.services;

import org.example.data.models.Post;
import org.example.dtos.requests.CreatePostRequest;
import org.example.dtos.requests.LoginUserRequest;
import org.example.dtos.requests.LogoutUserRequest;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.dtos.responses.CreatePostResponse;
import org.example.dtos.responses.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    Long count();

    void loginUser(LoginUserRequest loginUserRequest);


    void logoutUser(LogoutUserRequest logoutUserRequest);
    CreatePostResponse createPost(CreatePostRequest createPostRequest);

    Post findPost(String author);

    void deletePost(String title);

    Long countPost();
}
