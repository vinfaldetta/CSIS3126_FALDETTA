package com.faldetta.financebackend.controller;

import com.faldetta.financebackend.dto.LoginRequest;
import com.faldetta.financebackend.entity.User;
import com.faldetta.financebackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepo;

    public AuthController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        return userRepo.findByUsername(req.getUsername())
                .filter(user -> user.getPassword().equals(req.getPassword()))
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401)
                        .body("Invalid username or password"));
    }
}