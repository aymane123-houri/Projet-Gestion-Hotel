package org.example.reservationservice.repository;

import org.example.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation getReservationByUserId(Long userId);
    Reservation getReservationByChambreId(Long chambreId);
    List<Reservation> getAllByDateDebut(String date);
}
