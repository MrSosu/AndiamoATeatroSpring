package com.develhope.JTeathreSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
public class Hall {

    public Hall(int id, String name, Venue venue) {
        this.id = id;
        this.name = name;
        this.venue = venue;
    }

    public Hall(String name, Venue venue) {
        this.name = name;
        this.venue = venue;
    }

    public Hall() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Venue venue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
