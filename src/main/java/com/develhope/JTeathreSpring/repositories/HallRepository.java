package com.develhope.JTeathreSpring.repositories;

import com.develhope.JTeathreSpring.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
}
