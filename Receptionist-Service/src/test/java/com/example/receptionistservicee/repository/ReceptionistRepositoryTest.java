package com.example.receptionistservicee.repository;

import com.example.receptionistservicee.entity.Receptionist;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReceptionistRepositoryTest {

    @Autowired
    private ReceptionistRepository receptionistRepository;


    //la premiere methode qui va lance je vais ajouter des belement dans la base de donner pour les autre methodes va fonctionne
    @BeforeEach
    void setUp(){
        receptionistRepository.save(new Receptionist("null","user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234","Admin"));
        receptionistRepository.save(new Receptionist("null","user2","user2","user2@gmail.com","1234","0666666","Rue malik","L56789","Receptionist"));
    }
    @Test
    void findByEmail() {
        String email="houri@gmail.com";
        Receptionist receptionist  = new Receptionist("null","user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234","Admin");

        Receptionist result=receptionistRepository.findByEmail(email);

        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(receptionist);
    }
}