package com.example.First.project.repository;

import com.example.First.project.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, ObjectId> {
    Users findByUsername(String username);
}
