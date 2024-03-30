package org.example.data.repositories.repositoriesTest;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void initializer(){
        userRepository.deleteAll();
    }

    @Test
    public void saveUser(){
        User user = new User();
        userRepository.save(user);
        assertEquals(1,userRepository.count());
    }

    @Test
    public void saveTwoUser(){
        User user = new User();
        userRepository.save(user);
        User user1 = new User();
        userRepository.save(user1);
        assertEquals(2,userRepository.count());

    }

    @Test
    public void saveTwoUser_deleteByUserName(){
        User user = new User();
        user.setUsername("praise");
        userRepository.save(user);
        User user1 = new User();
        user.setUsername("marvellous");
        userRepository.save(user1);
        userRepository.deleteById("praise");
        assertEquals(1,userRepository.count());
    }

    @Test
    public void saveTwoUser_deleteAll(){
        User user = new User();
        user.setUsername("praise");
        userRepository.save(user);
        User user1 = new User();
        user.setUsername("marvellous");
        userRepository.save(user1);
        userRepository.deleteAll();
        assertEquals(0,userRepository.count());
    }

    @Test
    public void saveUser_findUserbyUsername() {
        User user = new User();
        user.setUsername("praise");
        userRepository.save(user);
        User user1 = new User();
        user.setUsername("marvellous");
        userRepository.save(user1);
        Optional<User> foundUser = userRepository.findById("praise");
        assertEquals(foundUser, userRepository.findById("praise"));



    }

    @Test
    public void saveUser_findUser_deleteUser(){
        User user = new User();
        user.setUsername("praise");
        userRepository.save(user);
        User user1 = new User();
        user.setUsername("marvellous");
        userRepository.save(user1);
        Optional<User> foundUser = userRepository.findById("marvellous");
        assertEquals(foundUser,userRepository.findById("marvellous"));
        userRepository.delete(user);
        assertEquals(1,userRepository.count());
    }

    @Test
    public void saveuser_deleteAll(){
        User user = new User();
        user.setUsername("praise");
        userRepository.save(user);
        User user1 = new User();
        user.setUsername("marvellous");
        userRepository.save(user1);
        userRepository.deleteAll();
        assertEquals(0,userRepository.count());
    }

    @Test
    public void saveUser_findAll(){
        User user = new User();
        user.setUsername("praise");
        userRepository.save(user);
        User user1 = new User();
        user.setUsername("marvellous");
        userRepository.save(user1);
        userRepository.findAll();
        assertEquals(2,userRepository.count());
    }


    }


