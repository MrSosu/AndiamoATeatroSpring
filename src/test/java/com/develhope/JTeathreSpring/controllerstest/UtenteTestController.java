package com.develhope.JTeathreSpring.controllerstest;

import com.develhope.JTeathreSpring.entities.Utente;
import com.develhope.JTeathreSpring.entities.Venue;
import com.develhope.JTeathreSpring.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utenteTest")
public class UtenteTestController {

    @Autowired
    private UtenteRepository utenteRepository;

    @PostMapping("/register")
    public void createUser(@RequestBody Utente utente) {
        utenteRepository.saveAndFlush(utente);
    }

    @GetMapping("/get/{id}")
    public Utente getUtente(@PathVariable Long id_utente) {
        Optional<Utente> optionalUtente = utenteRepository.findById(id_utente);
        if (optionalUtente.isEmpty()) throw new IllegalArgumentException("l'utente non esiste!");
        return optionalUtente.get();
    }

    @GetMapping("/getall")
    public List<Utente> getAllLocations() {
        return utenteRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        utenteRepository.deleteById(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        utenteRepository.deleteAll();
    }


}

