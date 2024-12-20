package org.example.userservice.repository;

import org.assertj.core.api.AssertionsForClassTypes;
import org.example.userservice.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;



    @BeforeEach
    void setUp(){
        userRepository.save(new User(null,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234"));
        userRepository.save(new User(null,"user2","user2","user2@gmail.com","0666666666","Rue malik","LA789","1234"));
    }

    @org.junit.jupiter.api.Test
    void findByEmail() {
        String email="user1@gmail.com";
        User user  = new User(null,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234");

        User result=userRepository.findByEmail(email);

        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(user);
    }




    //la premiere methode qui va lance je vais ajouter des belement dans la base de donner pour les autre methodes va fonctionne


}