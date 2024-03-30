package org.example.data.repositories;

import org.example.data.models.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewRepository extends MongoRepository<View,String> {

}
