package com.example.reservationservicee.repositoty;

import com.example.reservationservicee.entity.Reservation;
import com.example.reservationservicee.model.Chambre;
import com.example.reservationservicee.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;


    //la premiere methode qui va lance je vais ajouter des belement dans la base de donner pour les autre methodes va fonctionne
    @BeforeEach
    void setUp(){
        reservationRepository.save(new Reservation( null,1L,1L,new Date(),new Date(),1000,new User(null,"user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234"),new Chambre(null,"100",2,300,"image.png","test",true,3,2,"double")));
        reservationRepository.save(new Reservation( null,2L,2L,new Date(),new Date(),2000,new User(null,"user2","user2","user2@gmail.com","1234","0666666","Rue malik","L56789"),new Chambre(null,"101",2,300,"image.png","test",true,3,2,"double")));
    }
    @Test
    void findChambresReservees() {
    }
}