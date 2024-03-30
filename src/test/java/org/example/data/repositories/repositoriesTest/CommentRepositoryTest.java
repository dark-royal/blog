package org.example.data.repositories.repositoriesTest;

import org.example.data.models.Comment;
import org.example.data.repositories.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @BeforeEach
    public void initializer(){
        commentRepository.deleteAll();
    }


    @Test
    public void saveComment(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertEquals(1,commentRepository.count());
    }

    @Test
    public void saveTwoComment(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        Comment comment1 = new Comment();
        commentRepository.save(comment1);
        assertEquals(2,commentRepository.count());

    }

    @Test
    public void saveTwoView_deleteOneComment(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        Comment comment1 = new Comment();
        commentRepository.save(comment1);
        commentRepository.delete(comment);
        assertEquals(1,commentRepository.count());

    }

    @Test
    public void saveTwoView_deleteTwoComment(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        Comment comment1 = new Comment();
        commentRepository.save(comment1);
        commentRepository.delete(comment);
        commentRepository.delete(comment1);
        assertEquals(0,commentRepository.count());

    }


    @Test
    public void saveTwoView_findAllComment(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        Comment view1 = new Comment();
        commentRepository.save(view1);
        commentRepository.findAll();
        assertEquals(2,commentRepository.count());

    }

    @Test
    public void saveTwoView_findComment(){
        Comment comment = new Comment();
        comment.setComment("i love this");
        commentRepository.save(comment);
        Comment view1 = new Comment();
        comment.setComment("ooh this is so bad");
        commentRepository.save(view1);
        Optional<Comment> foundComment = commentRepository.findById("ooh this is so bad");
        assertEquals(foundComment,commentRepository.findById("ooh this is so bad"));

    }

//    @Test
//    public void saveTwoView_findComment_deleteComment(){
//        Comment comment = new Comment();
//        comment.setComment("i love this");
//        commentRepository.save(comment);
//        Comment view1 = new Comment();
//        comment.setComment("ooh this is so bad");
//        commentRepository.save(view1);
//        Optional<Comment> foundComment = commentRepository.findById("ooh this is so bad");
//        assertEquals(foundComment,commentRepository.findById("ooh this is so bad"));
//        commentRepository.deleteById(String.valueOf(foundComment));
//        assertEquals(1,commentRepository.count());
//
//    }




}