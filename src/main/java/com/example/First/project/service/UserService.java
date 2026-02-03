package com.example.First.project.service;

import com.example.First.project.entity.Users;
import com.example.First.project.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAll () {
        return userRepository.findAll();
    }

    public Optional<Users> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public Users saveEntry (Users user) {
        return userRepository.save(user);
    }

    public Users findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
