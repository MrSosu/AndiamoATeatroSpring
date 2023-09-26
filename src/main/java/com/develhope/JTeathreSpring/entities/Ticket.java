package com.develhope.JTeathreSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private LocalDate dateOfPurchase;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Liveshow show;

    public Ticket(LocalDate dateOfPurchase, Utente utente, Seat seat, Liveshow show) {
        this.dateOfPurchase = dateOfPurchase;
        this.utente = utente;
        this.seat = seat;
        this.show = show;
    }
}
