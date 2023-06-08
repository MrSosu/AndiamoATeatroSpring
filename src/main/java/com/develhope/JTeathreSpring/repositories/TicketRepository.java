package com.develhope.JTeathreSpring.repositories;

import com.develhope.JTeathreSpring.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


    @Query(value = "select id from ticket where seat_id = :seat and show_id = :show", nativeQuery = true)
    Collection<Ticket> getTicketBooked(@Param("seat") Long seat_id, @Param("show") Long show_id);

}
