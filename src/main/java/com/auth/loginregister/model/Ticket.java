package com.auth.loginregister.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    private String solution; // Jawaban teknisi nanti

    private LocalDateTime createdAt;

    // Relasi ke User (Siapa yang lapor?)
    // Pastikan class 'User' sudah ada di package com.auth.loginregister.model
    @ManyToOne 
    @JoinColumn(name = "user_id")
    private User user; 

    // Constructor Kosong (Wajib)
    public Ticket() {}

    // Getter dan Setter (Bisa Generate Klik Kanan -> Source -> Generate Getters Setters)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TicketStatus getStatus() { return status; }
    public void setStatus(TicketStatus status) { this.status = status; }
    
    public String getSolution() { return solution; }
    public void setSolution(String solution) { this.solution = solution; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
