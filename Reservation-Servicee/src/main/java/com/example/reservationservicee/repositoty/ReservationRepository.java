package com.example.reservationservicee.repositoty;

import com.example.reservationservicee.entity.Reservation;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT r.chambre_id FROM Reservation r " +
            "WHERE (r.date_debut <= :dateFin AND r.date_fin >= :dateDebut)")
    List<Long> findChambresReservees(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
}
