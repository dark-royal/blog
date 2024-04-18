package org.example.services;

import org.example.data.models.Post;
import org.example.data.repositories.PostRepository;
import org.example.dtos.requests.CreatePostRequest;
import org.example.dtos.responses.CreatePostResponse;
import org.example.exceptons.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.utils.Mapper.map;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
        Post post = map(createPostRequest);
        CreatePostResponse result = map(post);
        postRepository.save(post);
        return result;    }

    @Override
    public Post findPost(String author) {
        Post foundPost = postRepository.findPostBy(author);
        if (foundPost == null) throw new PostNotFoundException("post not found");
        return foundPost;
    }

    @Override
    public void deletePost(String title) {
        Post post = findPost(title);
        postRepository.delete(post);
    }

    @Override
    public Long countPost() {
        return postRepository.count();
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void deleteAll() {
        postRepository.deleteAll();
    }
}
