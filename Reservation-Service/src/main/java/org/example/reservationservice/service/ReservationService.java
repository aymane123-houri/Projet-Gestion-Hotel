package org.example.reservationservice.service;

import org.example.reservationservice.entity.Reservation;
import org.example.reservationservice.feignClient.ChambreFeignClient;
import org.example.reservationservice.feignClient.UserFeignClient;
import org.example.reservationservice.model.Chambre;
import org.example.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ChambreFeignClient chambreFeignClient;
    private final UserFeignClient userFeignClient;

    public ReservationService(ReservationRepository reservationRepository, ChambreFeignClient chambreFeignClient, UserFeignClient userFeignClient) {
        this.reservationRepository = reservationRepository;
        this.chambreFeignClient = chambreFeignClient;
        this.userFeignClient = userFeignClient;
    }

    public Reservation GetReservaionById(Long id){
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        assert reservation != null;
        reservation.setUser(userFeignClient.getUserById(reservation.getUserId()));
        reservation.setChambre(chambreFeignClient.getChambreById(reservation.getChambreId()));
        return reservation;
    }

    public Reservation GetReservaionByUserId(Long id){
        Reservation reservation = reservationRepository.getReservationByUserId(id);
        assert reservation != null;
        reservation.setUser(userFeignClient.getUserById(reservation.getUserId()));
        reservation.setChambre(chambreFeignClient.getChambreById(reservation.getChambreId()));
        return reservation;
    }

    public Reservation GetReservationByChambreId(Long id){
        Reservation reservation = reservationRepository.getReservationByChambreId(id);
        assert reservation != null;
        reservation.setUser(userFeignClient.getUserById(reservation.getUserId()));
        reservation.setChambre(chambreFeignClient.getChambreById(reservation.getChambreId()));
        return reservation;
    }

    public List<Reservation> GetReservationByDate_Debut(String date){
        List<Reservation> reservations = reservationRepository.getAllByDateDebut(date);
        for (Reservation reservation : reservations){
            reservation.setUser(userFeignClient.getUserById(reservation.getUserId()));
            reservation.setChambre(chambreFeignClient.getChambreById(reservation.getChambreId()));
        }
        return reservations;
    }

    public List<Reservation> GetAllReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations){
            reservation.setUser(userFeignClient.getUserById(reservation.getUserId()));
            reservation.setChambre(chambreFeignClient.getChambreById(reservation.getChambreId()));
        }
        return reservations;
    }

    public String CreateReservation(Reservation reservation){
        try {
            Chambre chambre = chambreFeignClient.getChambreById(reservation.getChambreId());
            reservation.setMontant_total(calculateMontantTotal(reservation.getDateDebut(), reservation.getDateFin(), chambre.getPrix()));

            reservationRepository.save(reservation);
            return "Reservation enregistrée avec success";
        }
        catch (Exception exception){
            return "Erreur: " + exception.getMessage();
        }
    }

    public String UpdateReservaion(Reservation reservation){
        try {
            if (GetReservaionById(reservation.getId()) == null)
                return "Reservation n'exist pas!";
            else {
                Chambre chambre = chambreFeignClient.getChambreById(reservation.getChambreId());
                reservation.setMontant_total(calculateMontantTotal(reservation.getDateDebut(), reservation.getDateFin(), chambre.getPrix()));
                reservationRepository.save(reservation);
                return "Reservation modifiée avec success";
            }
        }
        catch (Exception exception){
            return "Erreur: " + exception.getMessage();
        }
    }

    public String DeleteReservation(Reservation reservation){
        try {
            reservationRepository.delete(reservation);
            return "Reservation supprimée avec success";
        }
        catch (Exception exception){
            return "Erreur: " + exception.getMessage();
        }
    }

    private float calculateMontantTotal(String date_debut, String date_fin, float pricePerNight){
        // Define the date format (adjust to match your input date format)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the strings to LocalDate
        LocalDate startDate = LocalDate.parse(date_debut, formatter);
        LocalDate endDate = LocalDate.parse(date_fin, formatter);

        // Calculate the number of nights
        long nights = ChronoUnit.DAYS.between(startDate, endDate);

        // Ensure it's non-negative (end date should be after start date)
        if (nights < 0) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
        System.out.println("Nights: " + nights);
        System.out.println("Totale: " + nights * pricePerNight);
        return nights * pricePerNight;
    }

}
