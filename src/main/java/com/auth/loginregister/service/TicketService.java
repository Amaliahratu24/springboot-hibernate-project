package com.auth.loginregister.service;


import com.auth.loginregister.model.Ticket;
import com.auth.loginregister.model.TicketStatus;
import com.auth.loginregister.model.User;
import com.auth.loginregister.repository.TicketRepository;
import com.auth.loginregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    // 1. User Membuat Tiket (Status otomatis OPEN)
    public Ticket createTicket(String username, Ticket ticketData) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        ticketData.setUser(user);
        ticketData.setStatus(TicketStatus.OPEN); // Set awal BPM
        ticketData.setCreatedAt(LocalDateTime.now());
        
        return ticketRepository.save(ticketData);
    }

    // 2. Teknisi mengubah status ke IN_PROGRESS
    public Ticket startProgress(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setStatus(TicketStatus.IN_PROGRESS);
        return ticketRepository.save(ticket);
    }

    // 3. Teknisi menyelesaikan masalah (CLOSED) dan beri solusi
    public Ticket closeTicket(Long ticketId, String solution) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setStatus(TicketStatus.CLOSED);
        ticket.setSolution(solution);
        return ticketRepository.save(ticket);
    }
    
    // Lihat semua tiket user tertentu
    public List<Ticket> getMyTickets(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return ticketRepository.findByUserId(user.getId());
    }
	 // Ambil semua tiket (untuk Admin)
	    public List<Ticket> getAllTickets() {
	        return ticketRepository.findAll();
    }
}