package com.payment.backend.controller;

import com.payment.backend.dto.LoginRequest;
import com.payment.backend.dto.LoginResponse;
import com.payment.backend.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) {
        // MVP: hardcoded user
        if ("admin".equals(req.getUsername()) && "admin123".equals(req.getPassword())) {
            String token = jwtUtil.generateToken(req.getUsername());
            return ResponseEntity.ok(new LoginResponse(true, token, "Login successful"));
        }
        return ResponseEntity.status(401).body(new LoginResponse(false, null, "Invalid credentials"));
    }
}

