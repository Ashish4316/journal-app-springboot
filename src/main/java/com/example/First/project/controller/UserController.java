package com.example.First.project.controller;

import com.example.First.project.entity.Users;
import com.example.First.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUser() {
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody Users user){
        userService.saveEntry(user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody Users user, @PathVariable String userName){
        Users userInDb = userService.findByUsername(userName);
        if (userInDb != null) {
            userInDb.setUsername(user.getUsername() != null && !user.getUsername().isEmpty() ? user.getUsername() : userInDb.getUsername());
            userInDb.setPassword(user.getPassword() != null && !user.getPassword().isEmpty() ? user.getPassword() : userInDb.getPassword());
            userService.saveEntry(userInDb);
            return new ResponseEntity<>(userInDb, HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
