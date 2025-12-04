package com.auth.loginregister.controller;


import com.auth.loginregister.model.Ticket;
import com.auth.loginregister.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*") // Agar bisa diakses dari frontend manapun
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // 1. LAPOR MASALAH (Create)
    // URL: http://localhost:8080/api/tickets/create?username=NAMA_USER_YG_LOGIN
    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(@RequestParam String username, @RequestBody Ticket ticket) {
        Ticket newTicket = ticketService.createTicket(username, ticket);
        return ResponseEntity.ok(newTicket);
    }

    // 2. LIHAT HISTORY TIKET SAYA
    // URL: http://localhost:8080/api/tickets/my-tickets?username=NAMA_USER_YG_LOGIN
    @GetMapping("/my-tickets")
    public ResponseEntity<List<Ticket>> getMyTickets(@RequestParam String username) {
        return ResponseEntity.ok(ticketService.getMyTickets(username));
    }
 // URL: http://localhost:8080/api/tickets/all
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }
	 // Di TicketController.java
	
	 // 1. Untuk Admin Klik tombol "Proses"
	 @PutMapping("/{id}/start")
	 public ResponseEntity<Ticket> startTicket(@PathVariable Long id) {
	     return ResponseEntity.ok(ticketService.startProgress(id));
	 }
	
	 // 2. Untuk Admin Klik tombol "Selesai" (menerima solusi string)
	 @PutMapping("/{id}/close")
	 public ResponseEntity<Ticket> closeTicket(@PathVariable Long id, @RequestBody String solution) {
	     return ResponseEntity.ok(ticketService.closeTicket(id, solution));
	 }
}
