package com.example.receptionistservicee.repository;

import com.example.receptionistservicee.entity.Receptionist;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
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
        // Préparer l'email à tester
        String email = "user1@gmail.com";

        // Créer un nouvel objet Receptionist sans l'ID pour la comparaison
        Receptionist expectedReceptionist = new Receptionist("null", "user1", "user1", email, "1234", "0666666", "Rue malik", "L1234", "Admin");

        // Sauvegarder dans la base de données
        receptionistRepository.save(expectedReceptionist);

        // Récupérer le receptionist par email
        Receptionist result = receptionistRepository.findByEmail(email);

        // Vérifier que le résultat n'est pas nul
        AssertionsForClassTypes.assertThat(result).isNotNull();

        // Comparer l'objet retourné avec l'objet attendu en ignorant l'ID
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison()
                .ignoringFields("id") // Ignorer le champ ID, qui est généré automatiquement
                .isEqualTo(expectedReceptionist);
    }

}