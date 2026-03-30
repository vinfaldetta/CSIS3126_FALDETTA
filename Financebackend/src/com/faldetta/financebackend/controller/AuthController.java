package com.faldetta.financebackend.controller;

import com.faldetta.financebackend.dto.LoginRequest;
import com.faldetta.financebackend.dto.UserResponse;
import com.faldetta.financebackend.entity.User;
import com.faldetta.financebackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body("Username already exists");
        }

        // HASH PASSWORD
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepo.save(user);

        UserResponse response = new UserResponse(
                savedUser.getId(),
                savedUser.getUsername()
        );

        return ResponseEntity.ok(response);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        var optionalUser = userRepo.findByUsername(req.getUsername());

        if (optionalUser.isEmpty()) {
            return ResponseEntity
                    .status(401)
                    .body("Invalid username or password");
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            return ResponseEntity
                    .status(401)
                    .body("Invalid username or password");
        }

        UserResponse response = new UserResponse(
                user.getId(),
                user.getUsername()
        );

        return ResponseEntity.ok(response);
    }
}