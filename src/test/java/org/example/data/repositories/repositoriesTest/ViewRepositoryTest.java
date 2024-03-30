package org.example.data.repositories.repositoriesTest;

import org.example.data.models.View;
import org.example.data.repositories.ViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
public class ViewRepositoryTest {
    @Autowired
    private ViewRepository viewRepository;

    @BeforeEach
    public void initializer(){
        viewRepository.deleteAll();
    }

    @Test
    public void saveView(){
        View view = new View();
        viewRepository.save(view);
        assertEquals(1,viewRepository.count());
    }

    @Test
    public void saveTwoView(){
        View view = new View();
        viewRepository.save(view);
        View view1 = new View();
        viewRepository.save(view1);
        assertEquals(2,viewRepository.count());

    }

    @Test
    public void saveTwoView_deleteOneView(){
        View view = new View();
        viewRepository.save(view);
        View view1 = new View();
        viewRepository.save(view1);
        viewRepository.delete(view);
        assertEquals(1,viewRepository.count());

    }

    @Test
    public void saveTwoView_deleteTwoView(){
        View view = new View();
        viewRepository.save(view);
        View view1 = new View();
        viewRepository.save(view1);
        viewRepository.delete(view);
        viewRepository.delete(view1);
        assertEquals(0,viewRepository.count());

    }


    @Test
    public void saveTwoView_findView(){
        View view = new View();
        viewRepository.save(view);
        View view1 = new View();
        viewRepository.save(view1);
        viewRepository.findAll();
        assertEquals(2,viewRepository.count());

    }
}