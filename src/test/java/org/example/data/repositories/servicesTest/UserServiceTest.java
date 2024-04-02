package org.example.data.repositories.servicesTest;

import org.example.data.models.Post;
import org.example.data.models.User;
import org.example.data.repositories.PostRepository;
import org.example.data.repositories.UserRepository;
import org.example.dtos.requests.CreatePostRequest;
import org.example.dtos.requests.LoginUserRequest;
import org.example.dtos.requests.LogoutUserRequest;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceTest {
    @Autowired
    private RegisterUserRequest registerUserRequest;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginUserRequest loginUserRequest;
    @Autowired
    private LogoutUserRequest logoutUserRequest;
    @Autowired
    private CreatePostRequest createPostRequest;
    @Autowired
    public PostRepository postRepository;

    @BeforeEach
    public void initializer() {
        registerUserRequest = new RegisterUserRequest();
        loginUserRequest = new LoginUserRequest();
        logoutUserRequest = new LogoutUserRequest();
        userRepository.deleteAll();
        postRepository.deleteAll();
        createPostRequest = new CreatePostRequest();
    }

    @Test
    public void registerUser() {
        User user = new User();

        registerUserRequest.setFirstName("praise");
        registerUserRequest.setLastName("oyewole");
        registerUserRequest.setUsername("dark royal");
        registerUserRequest.setPassword("israel");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
    }

    @Test
    public void login() {
        User user = new User();
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("praise");
        registerUserRequest.setLastName("oyewole");
        registerUserRequest.setUsername("dark royal");
        registerUserRequest.setPassword("israel");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
        loginUserRequest.setUsername("dark royal");
        loginUserRequest.setPassword("israel");
        userService.loginUser(loginUserRequest);
        assertTrue(user.isLoginStatus());

    }

    @Test
    public void userCan_register_login_andlogout() {
        User user = new User();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
        loginUserRequest.setUsername("username");
        loginUserRequest.setPassword("password");
        userService.loginUser(loginUserRequest);
        assertTrue(user.isLoginStatus());
        userService.logoutUser(logoutUserRequest);
        assertFalse(user.isLoginStatus());
    }

    @Test
    public void userCanRegister_Login_createPost() {
        User user = new User();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
        loginUserRequest.setUsername("username");
        loginUserRequest.setPassword("password");
        userService.loginUser(loginUserRequest);
        assertTrue(user.isLoginStatus());
        createPostRequest.setTitle("semicolon");
        createPostRequest.setContent("i love semicolon");
        userService.createPost(createPostRequest);
        assertEquals(1, userService.count());
    }

    @Test
    public void userCanRegister_login_createPost_findPost() {
        User user = new User();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
        loginUserRequest.setUsername("username");
        loginUserRequest.setPassword("password");
        userService.loginUser(loginUserRequest);
        assertTrue(user.isLoginStatus());
        createPostRequest.setTitle("semicolon");
        createPostRequest.setContent("i love semicolon");
        createPostRequest.setAuthor("praise");
        createPostRequest.setDatePosted(createPostRequest.getDatePosted());
        userService.createPost(createPostRequest);
        assertEquals(1, userService.count());
        Post post = userService.findPost("praise");
        assertEquals(post, userService.findPost("praise"));

    }

    @Test
    public void userCanRegister_login_createEntry_deleteEntry() {
        User user = new User();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());

        loginUserRequest.setUsername("username");
        loginUserRequest.setPassword("password");
        userService.loginUser(loginUserRequest);
        assertTrue(user.isLoginStatus());

        createPostRequest.setTitle("semicolon");
        createPostRequest.setContent("i love semicolon");
        System.out.println(createPostRequest.getDatePosted());
        userService.createPost(createPostRequest);
        assertEquals(1, userService.count());

        Post post = userService.findPost("semicolon");
        assertEquals("semicolon", post.getTitle());

        userService.deletePost("semicolon");
        assertEquals(0, userService.countPost());

    }
}
