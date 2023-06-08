package com.develhope.JTeathreSpring.controllers;

import com.develhope.JTeathreSpring.entities.Hall;
import com.develhope.JTeathreSpring.entities.Ticket;
import com.develhope.JTeathreSpring.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    private HallRepository hallRepository;

    @PostMapping("/create")
    public void createHall(@RequestBody Hall hall) {
        hallRepository.saveAndFlush(hall);
    }

}
