package com.develhope.JTeathreSpring.controllers;

import com.develhope.JTeathreSpring.entities.Liveshow;
import com.develhope.JTeathreSpring.repositories.LiveshowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class LiveshowController {

    @Autowired
    private LiveshowRepository liveshowRepository;

    @PostMapping("/create")
    public void createShow(@RequestBody Liveshow liveshow) {
        liveshowRepository.saveAndFlush(liveshow);
    }

}
