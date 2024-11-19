package org.example.reservationservice.service;

import org.example.reservationservice.entity.Reservation;
import org.example.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservations() {

        return reservationRepository.findAll();


    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation update(Reservation reservation, Long id) {
        return reservationRepository.findById(id).map( reservation1 -> {
                 reservation1.setChambreId(reservation.getChambreId());
                 reservation1.setDate_debut(reservation.getDate_debut());
                 reservation1.setDate_fin(reservation.getDate_fin());
                 reservation1.setStatus(reservation.getStatus());
                 reservation1.setUserId(reservation.getUserId());
                 reservation1.setMontant_total(reservation.getMontant_total());
                 return reservationRepository.save(reservation1);

    }).orElseThrow(() -> new RuntimeException("reservation not found"));
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }


}
