package com.develhope.JTeathreSpring.repositories;

import com.develhope.JTeathreSpring.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
