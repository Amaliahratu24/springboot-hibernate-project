package com.auth.loginregister.repository;


import com.auth.loginregister.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Cari tiket berdasarkan user (history pelaporan user)
    List<Ticket> findByUserId(Long userId);
}
