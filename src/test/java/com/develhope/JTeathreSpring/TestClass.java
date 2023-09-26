package com.develhope.JTeathreSpring;

import com.develhope.JTeathreSpring.controllers.*;
import com.develhope.JTeathreSpring.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestClass {

    @Autowired
    private UtenteController utenteController;
    @Autowired
    private LiveshowController liveshowController;
    @Autowired
    private VenueController venueController;
    @Autowired
    private HallController hallController;
    @Autowired
    private SeatController seatController;
    @Autowired
    private TicketController ticketController;

    @Test
    public void dummyTest() {
        System.out.println("Un test da imbecilli");
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void testUserCrud() {
        Utente utente = new Utente();
        utente.setName("Marco");
        utente.setSurname("Adriani");
        utente.setEmail("marco@gmail.com");
        utente.setAddress("via fasulla 123");
        utente.setPhoneNumber("33333333333");
        utenteController.createUser(utente);

        Assertions.assertEquals(utenteController.getUtente((long) utente.getId()), utente);

        // testiamo il delete
        utenteController.deleteById(utente.getId());
        Assertions.assertThrows(IllegalArgumentException.class, () -> utenteController.getUtente((long) utente.getId()));
    }


    @Test
    public void testBuyTicket() {
        // creo un utente
        Utente utente = new Utente();
        utente.setName("Marco");
        utente.setSurname("Adriani");
        utente.setEmail("marco@gmail.com");
        utente.setAddress("via fasulla 123");
        utente.setPhoneNumber("33333333333");
        utenteController.createUser(utente);
        // creo una venue
        Venue venue = new Venue();
        venue.setCity("Roma");
        venue.setIsIndoors(true);
        venue.setName("Teatro dell'Opera");
        venue.setAddress("piazza della Repubblica 16");
        venueController.createLocation(venue);
        // creo una hall
        Hall hall = new Hall();
        hall.setVenue(venueController.getLocationById(venue.getId()));
        hall.setName("Sala principale");
        hallController.createHall(hall);
        // creo un liveshow
        Liveshow liveshow = new Liveshow();
        liveshow.setPrice(50.00);
        liveshow.setDurationInMinutes(120);
        liveshow.setDate(LocalDate.now());
        liveshow.setHall(hall);
        liveshow.setGenre("commedia");
        liveshow.setName("Pippo va in città");
        liveshowController.createShow(liveshow);
        // creo un seat
        Seat seat = new Seat();
        seat.setLineNumber(5);
        seat.setSeatNumber(25);
        seatController.createSeat(seat);
        // creo un ticket
        Ticket ticket = new Ticket();
        ticket.setDateOfPurchase(LocalDate.now().plusDays(5));
        ticket.setSeat(seat);
        ticket.setShow(liveshow);
        ticket.setUtente(utente);

        Assertions.assertEquals(utenteController.buyTicket(utente.getId(), seat.getId(), liveshow.getId()), 50.00);
        // Assertions.assertEquals(ticketController.getTicket((long) ticket.getId()), ticket);

    }


}
