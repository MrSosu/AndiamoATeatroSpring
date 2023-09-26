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
public class Liveshow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int durationInMinutes;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String genre;
    @ManyToOne
    private Hall hall;
}
