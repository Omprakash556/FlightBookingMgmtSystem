package com.casestudy.usermicroservice.controller;

import com.casestudy.usermicroservice.model.User;
import com.casestudy.usermicroservice.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }
}
