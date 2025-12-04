package com.auth.loginregister.repository;

import com.auth.loginregister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Cari user berdasarkan username
    Optional<User> findByUsername(String username);
    
    // Cek apakah username sudah ada
    boolean existsByUsername(String username);
    
    // Cari user berdasarkan email
    Optional<User> findByEmail(String email);
}