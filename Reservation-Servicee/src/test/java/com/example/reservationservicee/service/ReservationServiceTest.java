package com.example.reservationservicee.service;

import com.example.reservationservicee.entity.Reservation;

import com.example.reservationservicee.model.Chambre;
import com.example.reservationservicee.model.User;
import com.example.reservationservicee.repositoty.ReservationRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    void create_reservation() {
        Reservation reservation = new Reservation(
                null, 1L, 1L, new Date(), new Date(), 1000,
                new User(null, "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234"),
                new Chambre(null, "100", 2, 300, "image.png", "test", true, 3, 2, "double")
        );
        Reservation savedReservation = new Reservation(
                1L, 1L, 1L, new Date(), new Date(), 1000,
                new User(null, "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234"),
                new Chambre(null, "100", 2, 300, "image.png", "test", true, 3, 2, "double")
        );

        Mockito.when(reservationRepository.save(reservation)).thenReturn(savedReservation);

        Reservation result = reservationService.create_reservation(reservation);

        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(savedReservation);
    }

    @Test
    void getAll_reservation() {
        List<Reservation> reservationList = List.of(
                new Reservation(1L, 1L, 1L, new Date(), new Date(), 1000,
                        new User(null, "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234"),
                        new Chambre(null, "100", 2, 300, "image.png", "test", true, 3, 2, "double")),
                new Reservation(2L, 2L, 2L, new Date(), new Date(), 2000,
                        new User(null, "user2", "user2", "user2@gmail.com", "5678", "0677777", "Rue aziz", "L5678"),
                        new Chambre(null, "101", 3, 500, "image2.png", "test2", true, 4, 3, "suite"))
        );

        Mockito.when(reservationRepository.findAll()).thenReturn(reservationList);

        List<Reservation> result = reservationService.getAll_reservation();

        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(reservationList);
    }

    @Test
    void get_reservation() {
        Long id = 1L;
        Reservation reservation = new Reservation(
                1L, 1L, 1L, new Date(), new Date(), 1000,
                new User(null, "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234"),
                new Chambre(null, "100", 2, 300, "image.png", "test", true, 3, 2, "double")
        );

        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));

        Reservation result = reservationService.get_reservation(id);

        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(reservation);
    }

    @Test
    void update_reservation() {
        Long id = 1L;
        Reservation reservation = new Reservation(
                1L, 1L, 1L, new Date(), new Date(), 1000,
                new User(null, "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234"),
                new Chambre(null, "100", 2, 300, "image.png", "test", true, 3, 2, "double")
        );
        Reservation updatedReservation = new Reservation(
                1L, 1L, 1L, new Date(), new Date(), 1500,
                new User(null, "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234"),
                new Chambre(null, "100", 2, 300, "image.png", "test", true, 3, 2, "double")
        );

        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));
        Mockito.when(reservationRepository.save(reservation)).thenReturn(updatedReservation);

        Reservation result = reservationService.update_reservation(updatedReservation, id);

        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(updatedReservation);
    }

    @Test
    void delete_reservation() {
        Long id = 1L;

        Mockito.doNothing().when(reservationRepository).deleteById(id);

        reservationService.delete_reservation(id);

        Mockito.verify(reservationRepository, Mockito.times(1)).deleteById(id);
    }

    /*@Test
    void getChambresDisponibles() {
        List<Chambre> chambreList = List.of(
                new Chambre(null, "100", 2, 300, "image.png", "test", true, 3, 2, "double"),
                new Chambre(null, "101", 3, 500, "image2.png", "test2", true, 4, 3, "suite")
        );

        Mockito.when(reservationRepository.findChambresReservees(new Date(),new Date())).thenReturn(List<2>);

        List<Chambre> result = reservationService.getChambresDisponibles(new Date(),new Date(),2,2);

        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(chambreList);
    }*/
}
