package org.example.services;

import org.example.data.models.Post;
import org.example.dtos.requests.CreatePostRequest;
import org.example.dtos.responses.CreatePostResponse;

import java.util.Collection;
import java.util.List;

public interface PostService {

    CreatePostResponse createPost(CreatePostRequest createPostRequest);

    Post findPost(String author);

    void deletePost(String title);

    Long countPost();

    List<Post> findAllPost();

    void deleteAll();

}
