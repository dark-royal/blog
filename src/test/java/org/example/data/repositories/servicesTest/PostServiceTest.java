package org.example.data.repositories.servicesTest;

import org.example.dtos.requests.CreatePostRequest;
import org.example.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @BeforeEach
    public void setPostService(){
        postService.deleteAll();
    }

    @Test
    public void testPostCanBeCreated(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setAuthor("praise");
        createPostRequest.setTitle("The Boss");
        createPostRequest.setContent("The boss is good");
        createPostRequest.setDatePosted(LocalDateTime.now());
        postService.createPost(createPostRequest);
        assertEquals(1,postService.findAllPost().size());
    }

    @Test
    public void testTwoPostCanBeCreated(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setAuthor("praise");
        createPostRequest.setTitle("The Boss");
        createPostRequest.setContent("The boss is good");
        createPostRequest.setDatePosted(LocalDateTime.now());
        postService.createPost(createPostRequest);


        CreatePostRequest createPostRequest1 = new CreatePostRequest();
        createPostRequest1.setAuthor("praise1");
        createPostRequest1.setTitle("The Boss1");
        createPostRequest1.setContent("The boss is good1");
        createPostRequest1.setDatePosted(LocalDateTime.now());
        postService.createPost(createPostRequest1);
        assertEquals(2,postService.findAllPost().size());
    }

//    @Test
//    public void testPostCanBeDeleted

}
