package com.example.reservationservicee.controller;

import com.example.reservationservicee.entity.Reservation;
import com.example.reservationservicee.model.Chambre;
import com.example.reservationservicee.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Reservations")
public class ReservationController {


    public ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        logger.info("Données reçues pour la réservation : {}", reservation);
        return ResponseEntity.ok(reservationService.create_reservation(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation,@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.update_reservation(reservation,id));
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.delete_reservation(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.get_reservation(id));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation() {
        return ResponseEntity.ok(reservationService.getAll_reservation());
    }


    @GetMapping("/chambres-disponibles")
    public ResponseEntity<List<Chambre>> getChambresDisponibles(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDebut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFin,
            @RequestParam int nombreAdulte,
            @RequestParam int nombreEnfant
    ) {
        try {
            List<Chambre> chambresDisponibles = reservationService.getChambresDisponibles(dateDebut,dateFin,nombreAdulte,nombreEnfant);
            return ResponseEntity.ok(chambresDisponibles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}