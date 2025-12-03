package com.auth.loginregister.controller;

import com.auth.loginregister.dto.LoginRequest;
import com.auth.loginregister.dto.RegisterRequest;
import com.auth.loginregister.dto.AuthResponse;
import com.auth.loginregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    // Endpoint Register
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        String result = userService.register(request);
        
        if (result.equals("Registration successful")) {
            return ResponseEntity.ok(
                new AuthResponse(true, result, request.getUsername())
            );
        } else {
            return ResponseEntity.badRequest().body(
                new AuthResponse(false, result)
            );
        }
    }
    
    // Endpoint Login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String result = userService.login(request);
        
        if (result.equals("Login successful")) {
            return ResponseEntity.ok(
                new AuthResponse(true, result, request.getUsername())
            );
        } else {
            return ResponseEntity.badRequest().body(
                new AuthResponse(false, result)
            );
        }
    }
    
    // Endpoint Logout
    @PostMapping("/logout")
    public ResponseEntity<AuthResponse> logout() {
        String result = userService.logout();
        return ResponseEntity.ok(
            new AuthResponse(true, result)
        );
    }
    
    // Test Endpoint (untuk cek apakah API jalan)
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API is working!");
    }
}