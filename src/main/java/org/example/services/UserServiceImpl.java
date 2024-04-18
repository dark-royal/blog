package org.example.services;

import lombok.AllArgsConstructor;
import org.example.data.models.Post;
import org.example.data.models.User;
import org.example.data.repositories.PostRepository;
import org.example.data.repositories.UserRepository;
import org.example.dtos.requests.CreatePostRequest;
import org.example.dtos.requests.LoginUserRequest;
import org.example.dtos.requests.LogoutUserRequest;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.dtos.responses.CreatePostResponse;
import org.example.dtos.responses.RegisterUserResponse;
import org.example.exceptons.IncorrectUsernameException;
import org.example.exceptons.PostNotFoundException;
import org.example.exceptons.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.Mapper.map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements  UserService {


    private final UserRepository userRepository;


    private final PostRepository postRepository;

    private  final List<Post> posts;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        registerUserRequest.setUsername(registerUserRequest.getUsername().toLowerCase());
        validate(registerUserRequest.getUsername());
        User user = map(registerUserRequest);
        RegisterUserResponse result = map(user);
        userRepository.save(user);
        return result;
    }

    @Override
    public Long count() {
        return userRepository.count();


    }

    @Override
    public void loginUser(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByUsername(loginUserRequest.getUsername());
        if (user == null) throw new UserNotFoundException("user not found");
        if (!user.getUsername().equalsIgnoreCase(loginUserRequest.getUsername()) && user.getPassword().equalsIgnoreCase(loginUserRequest.getPassword()))
            throw new IncorrectUsernameException("invalid username or password");
        else {
            user.setLoginStatus(true);
        }
    }

    @Override
    public void logoutUser(LogoutUserRequest logoutUserRequest) {
        User user1 = userRepository.findByUsername(logoutUserRequest.getUsername());
        if (user1 == null) throw new UserNotFoundException("user not found");
        if (!user1.getUsername().equalsIgnoreCase(logoutUserRequest.getUsername()))
            throw new IncorrectUsernameException("incorrect username ");
        else {
            user1.setLoginStatus(false);
            userRepository.save(user1);
        }
    }


    public void validate(String username) {
        boolean exists = userRepository.existsByUsername(username);
        if (exists) throw new UsernameExistException(String.format("%s already exist", username));

    }

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
        Post post = map(createPostRequest);
        CreatePostResponse result = map(post);

        posts.add(post);
        postRepository.save(post);
        return result;


    }

    @Override
    public Post findPost(String author) {
        Post foundPost = postRepository.findPostBy(author);
        if (foundPost == null) throw new PostNotFoundException("post not found");
        return foundPost;
    }

    @Override
    public void deletePost(String author) {
        Post post = findPost(author);
        postRepository.delete(post);
    }
    @Override
    public Long countPost(){
        return postRepository.count();
    }
}
