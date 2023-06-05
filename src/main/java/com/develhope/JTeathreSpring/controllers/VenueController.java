package com.develhope.JTeathreSpring.controllers;

import com.develhope.JTeathreSpring.entities.Venue;
import com.develhope.JTeathreSpring.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venue")
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/get/{id}")
    public Venue getLocationById(@PathVariable long id) {
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) return optionalVenue.get();
        throw new IllegalArgumentException("id non presente nella tabella");
    }

    @GetMapping("/getall")
    public List<Venue> getAllLocations() {
        return venueRepository.findAll();
    }

    @PostMapping("/create")
    public void  createLocation(@RequestBody Venue location){
        venueRepository.saveAndFlush(location);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        venueRepository.deleteById(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        venueRepository.deleteAll();
    }

}
