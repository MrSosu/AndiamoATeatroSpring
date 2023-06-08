package com.develhope.JTeathreSpring.controllers;

import com.develhope.JTeathreSpring.entities.Seat;
import com.develhope.JTeathreSpring.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @PostMapping("/create")
    public void createSeat(@RequestBody Seat seat) {
        seatRepository.saveAndFlush(seat);
    }

}
