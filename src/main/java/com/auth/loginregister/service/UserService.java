package com.auth.loginregister.service;

import com.auth.loginregister.model.User;
import com.auth.loginregister.repository.UserRepository;
import com.auth.loginregister.dto.RegisterRequest;
import com.auth.loginregister.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // Register User
    public String register(RegisterRequest request) {
        // Cek apakah username sudah ada
        if (userRepository.existsByUsername(request.getUsername())) {
            return "Username already exists";
        }
        
        // Buat user baru
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword()); // Note: Sebaiknya di-hash dulu!
        newUser.setEmail(request.getEmail());
        
        // Simpan ke database
        userRepository.save(newUser);
        
        return "Registration successful";
    }
    
    // Login User
    public String login(LoginRequest request) {
        // Cari user berdasarkan username
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());
        
        if (userOptional.isEmpty()) {
            return "User not found";
        }
        
        User user = userOptional.get();
        
        // Cek password
        if (!user.getPassword().equals(request.getPassword())) {
            return "Invalid password";
        }
        
        return "Login successful";
    }
    
    // Logout User (simple implementation)
    public String logout() {
        return "Logout successful";
    }
}