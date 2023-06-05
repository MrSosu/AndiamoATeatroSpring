package com.develhope.JTeathreSpring.controllers;

import com.develhope.JTeathreSpring.entities.Ticket;
import com.develhope.JTeathreSpring.entities.Utente;
import com.develhope.JTeathreSpring.repositories.TicketRepository;
import com.develhope.JTeathreSpring.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/register")
    public void createTicket(@RequestBody Ticket ticket) {
        ticketRepository.saveAndFlush(ticket);
    }

    @GetMapping("/get/{id}")
    public Ticket getTicket(@PathVariable Long id_ticket) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id_ticket);
        if (optionalTicket.isEmpty()) throw new IllegalArgumentException("il ticket non esiste!");
        return optionalTicket.get();
    }

    @GetMapping("/getall")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        ticketRepository.deleteById(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        ticketRepository.deleteAll();
    }

}
