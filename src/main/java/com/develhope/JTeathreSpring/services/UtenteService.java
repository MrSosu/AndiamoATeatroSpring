package com.develhope.JTeathreSpring.services;

import com.develhope.JTeathreSpring.entities.Liveshow;
import com.develhope.JTeathreSpring.entities.Seat;
import com.develhope.JTeathreSpring.entities.Ticket;
import com.develhope.JTeathreSpring.entities.Utente;
import com.develhope.JTeathreSpring.repositories.LiveshowRepository;
import com.develhope.JTeathreSpring.repositories.SeatRepository;
import com.develhope.JTeathreSpring.repositories.TicketRepository;
import com.develhope.JTeathreSpring.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private LiveshowRepository liveshowRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private TicketRepository ticketRepository;

    /*
    Gli utenti registrati devono poter prenotare dei posti disponibili in uno spettacolo, e il sistema
    deve calcolare il prezzo da pagare per l’utente.
     */
    public Double buyTicket(@RequestParam Long id_utente, @RequestParam Long id_show, @RequestParam Long id_seat) {
        // 1) controllo se l'utente è registrato
        Optional<Utente> optionalUtente = utenteRepository.findById(id_utente);
        if (optionalUtente.isEmpty()) throw new IllegalArgumentException("l'utente non è registrato!");
        Utente utente = optionalUtente.get();

        // 2) controllo se lo spettacolo esista
        Optional<Liveshow> optionalLiveshow = liveshowRepository.findById(id_show);
        if (optionalLiveshow.isEmpty()) throw new IllegalArgumentException("lo show non esiste!");
        Liveshow liveshow = optionalLiveshow.get();

        // 3) controllo se il posto esista
        Optional<Seat> optionalSeat = seatRepository.findById(id_seat);
        if (optionalSeat.isEmpty()) throw new IllegalArgumentException("il posto non esiste!");
        Seat seat = optionalSeat.get();

        // 4) controllo se lo spettacolo non sia nel passato
        if (liveshow.getDate().isBefore(LocalDate.now())) throw new IllegalArgumentException("lo spettacolo è già finito!");

        // 5) controllo se il posto per quello spettacolo non sia già acquistato
        // if (ticketRepository.getTicketBooked(id_seat, id_show).size() > 0) throw new IllegalArgumentException("posto già prenotato");
        ticketRepository.saveAndFlush(new Ticket(LocalDate.now(), utente, seat, liveshow));
        System.out.println("Complimenti! Acquisto effettuato! Il prezzo che hai pagato è: " + liveshow.getPrice());
        return liveshow.getPrice();
    }

}
