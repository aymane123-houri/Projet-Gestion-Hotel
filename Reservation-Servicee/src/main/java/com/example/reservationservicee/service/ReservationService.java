package com.example.reservationservicee.service;

import com.example.reservationservicee.entity.Reservation;
import com.example.reservationservicee.feignClient.ChambreFeignClient;
import com.example.reservationservicee.feignClient.UserFeignClient;
import com.example.reservationservicee.model.Chambre;
import com.example.reservationservicee.repositoty.ReservationRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ChambreFeignClient chambreFeignClient;
    private UserFeignClient userFeignClient;

    public ReservationService(ReservationRepository reservationRepository, ChambreFeignClient chambreFeignClient, UserFeignClient userFeignClient) {
        this.reservationRepository = reservationRepository;
        this.chambreFeignClient = chambreFeignClient;
        this.userFeignClient = userFeignClient;
    }

    @Transactional
    public Reservation create_reservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAll_reservation() {
        List<Reservation> reservationList = reservationRepository.findAll();

        for(Reservation e: reservationList){
            e.setChambre(chambreFeignClient.getChambreById(e.getChambre_id()));

        }
        for(Reservation e: reservationList){
            e.setUser(userFeignClient.getUserById(e.getUser_id()));

        }

        return reservationList;
    }
    public Reservation get_reservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        reservation.setChambre(chambreFeignClient.getChambreById(reservation.getChambre_id()));
        reservation.setUser(userFeignClient.getUserById(reservation.getUser_id()));
        return  reservation;
    }

    public Reservation update_reservation(Reservation reservation, Long id) {
        return reservationRepository.findById(id).map(reservation1 -> {
                    reservation1.setDate_debut(reservation.getDate_debut());
                    reservation1.setDate_fin(reservation.getDate_fin());
                    reservation1.setMontant_total(reservation.getMontant_total());
                    reservation1.setChambre_id(reservation.getChambre_id());
                    reservation1.setUser_id(reservation.getUser_id());
                    return reservationRepository.save(reservation1);
                }

        ).orElseThrow((() -> new RuntimeException("user not found")));
    }



    public void delete_reservation(Long id) {
        reservationRepository.deleteById(id);
    }



    public List<Chambre> getChambresDisponibles(Date dateDebut, Date dateFin, int nombreAdulte, int nombreEnfant) {
            // Étape 1 : Récupérer les chambres réservées dans les dates données
            List<Long> chambresReservees = reservationRepository.findChambresReservees(dateDebut, dateFin);

            // Étape 2 : Récupérer toutes les chambres via le microservice Chambre
            List<Chambre> toutesLesChambres = chambreFeignClient.getAllChambres();

            // Étape 3 : Filtrer les chambres disponibles
            List<Chambre> chambresDisponibles = toutesLesChambres.stream()
                    .filter(chambre -> !chambresReservees.contains(chambre.getId()))
                    .filter(chambre -> chambre.getAdulte_capacite() >= nombreAdulte)
                    .filter(chambre -> chambre.getEnfant_capacite() >= nombreEnfant)
                    .collect(Collectors.toList());

            return chambresDisponibles;


    }

}