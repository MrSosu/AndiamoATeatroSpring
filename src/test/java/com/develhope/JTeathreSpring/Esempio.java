package com.develhope.JTeathreSpring;

import com.develhope.JTeathreSpring.controllers.*;
import com.develhope.JTeathreSpring.controllerstest.UtenteTestController;
import com.develhope.JTeathreSpring.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Esempio {

    @Autowired
    private UtenteController utenteController;

    @Autowired
    private VenueController venueController;

    @Autowired
    private HallController hallController;

    @Autowired
    private SeatController seatController;

    @Autowired
    private LiveshowController liveshowController;

    @Test
    public void dummyTest() {
        System.out.println("Un semplice test di esempio");
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void bohTest() {
        Utente utente = new Utente();
        utente.setEmail("ciccio@gmail.com");
        utente.setAddress("via casa mia 123");
        utente.setName("Ciccio");
        utente.setSurname("Pippo");
        utente.setPhoneNumber("3333578214");
        utenteController.createUser(utente);

        Assertions.assertEquals(utenteController.getUtente((long) utente.getId()), utente);

        utenteController.deleteById(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> utenteController.getUtente((long) utente.getId()));

        utenteController.createUser(utente);


    }

    @Test
    public void testTicket() {
        // creo un utente
        Utente utente = new Utente();
        utente.setEmail("pippo@gmail.com");
        utente.setAddress("via casa mia 123");
        utente.setName("Ciccio");
        utente.setSurname("Pippo");
        utente.setPhoneNumber("3333578214");
        utenteController.createUser(utente);
        // creo una venue
        Venue venue = new Venue();
        venue.setCity("Roma");
        venue.setName("Teatro Opera");
        venue.setIsIndoors(true);
        venue.setAddress("via fasulla 123");
        venueController.createLocation(venue);
        // creo una hall
        Hall hall = new Hall();
        hall.setName("sala bella");
        hall.setVenue(venue);
        hallController.createHall(hall);
        // creo un seat
        Seat seat = new Seat();
        seat.setHall(hall);
        seat.setSeatNumber(5);
        seat.setLineNumber(13);
        seatController.createSeat(seat);
        // creo un liveshow
        Liveshow liveshow = new Liveshow();
        liveshow.setHall(hall);
        liveshow.setDate(LocalDate.now().plusDays(5));
        liveshow.setGenre("spazzatura");
        liveshow.setDurationInMinutes(120);
        liveshow.setPrice(50.00);
        liveshowController.createShow(liveshow);


        Assertions.assertEquals(50.00, utenteController.buyTicket(utente.getId(), seat.getId(), liveshow.getId()));
    }

}
