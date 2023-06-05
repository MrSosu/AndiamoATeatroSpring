package com.develhope.JTeathreSpring.repositories;

import com.develhope.JTeathreSpring.entities.Liveshow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveshowRepository extends JpaRepository<Liveshow, Long> {
}
