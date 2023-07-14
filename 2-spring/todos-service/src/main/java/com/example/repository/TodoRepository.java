package com.example.repository;

import com.example.entity.Todo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, ObjectId> {

    @Query(value = "{ 'completed' : ?0 }")
    List<Todo> findByStatus(boolean completed);

}
