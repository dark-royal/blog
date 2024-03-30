package org.example.data.repositories.repositoriesTest;

import org.example.data.models.Post;
import org.example.data.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class PostRepositoryTest {
        @Autowired
        private PostRepository postRepository;

        @BeforeEach
        public void initializer(){
            postRepository.deleteAll();
        }

    @Test
    public void testPostCanBeSaved() {
        Post post = new Post();
        postRepository.save(post);
        assertEquals(1, postRepository.count());

    }

    @Test
    public void testTwoPostCanBeSaved(){
        Post post = new Post();
        postRepository.save(post);
        Post post1 = new Post();
        postRepository.save(post1);
        assertEquals(2, postRepository.count());


    }

    @Test
    public void testPostCanSave_deletePost(){
        Post post = new Post();
        postRepository.save(post);
        postRepository.delete(post);
        assertEquals(0, postRepository.count());



    }
    @Test
    public void testPostCanTwoSave_deleteOnePost() {
        Post post = new Post();
        postRepository.save(post);
        Post post1 = new Post();
        postRepository.save(post1);
        postRepository.delete(post1);
        assertEquals(1, postRepository.count());


    }

    @Test
    public void testPostCanSave_deletePostById() {
        Post post = new Post();
        postRepository.save(post);
        Post post1 = new Post();
        postRepository.save(post1);
        postRepository.findAll();
        assertEquals(2, postRepository.count());

    }

    @Test
    public void testPostCanSave_deleteAllPost() {
        Post post = new Post();
        postRepository.save(post);
        Post post1 = new Post();
        postRepository.save(post1);
        Post post2 = new Post();
        postRepository.save(post2);
        postRepository.deleteAll();
        assertEquals(0, postRepository.count());


    }

    @Test
    public void testPostCanSave_findPostByTitle() {
        Post post = new Post();
        post.setTitle("Semicolon");
        postRepository.save(post);
        Post post1 = new Post();
        post.setTitle("Praise");
        postRepository.save(post1);
        Optional<Post> foundPost = postRepository.findById("Semicolon");
        assertEquals(foundPost, postRepository.findById("Semicolon"));

    }

    }