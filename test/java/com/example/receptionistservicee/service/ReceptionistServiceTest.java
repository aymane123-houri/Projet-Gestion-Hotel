package com.example.receptionistservicee.service;

import com.example.receptionistservicee.entity.Receptionist;
import com.example.receptionistservicee.repository.ReceptionistRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ReceptionistServiceTest {

    @Mock
    private ReceptionistRepository receptionistRepository;


    @InjectMocks
    private ReceptionistService receptionistService;


    @Test
    void create_Receptionist() {
        Receptionist receptionist = new Receptionist("null","user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234","Admin");
        Receptionist Receptionistsaved = new Receptionist("1L","user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234","Admin");
        // action
        Mockito.when(receptionistRepository.save(receptionist)).thenReturn(Receptionistsaved);
        // tester
        Receptionist resultat = receptionistService.create_Receptionist(receptionist);
        // vérifier
        AssertionsForClassTypes.assertThat(resultat).usingRecursiveComparison().isEqualTo(Receptionistsaved);
    }

    @Test
    void getAll_receptionist() {
        List<Receptionist> receptionistList = List.of(
                new Receptionist("null","user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234","Admin"),
                new Receptionist("null","user2","user2","user2@gmail.com","1234","0666666","Rue malik","L56789","Receptionist")
        );
        // action
        Mockito.when(receptionistRepository.findAll()).thenReturn(receptionistList);
        List<Receptionist> result = receptionistService.getAll_receptionist();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(receptionistList);
    }

    @Test
    void get_receptionist() {
        String id = "1L";
        Receptionist receptionist = new Receptionist("1l","user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234","Admin");
        Mockito.when(receptionistRepository.findById(id)).thenReturn(Optional.of(receptionist));
        Receptionist result = receptionistService.get_receptionist(id);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(receptionist);
    }

    @Test
    void update_receptionist() {
        String id = "1L";
    Receptionist receptionist = new Receptionist("1L","user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234","Admin");
    Receptionist receptionist_modify = new Receptionist("1L","user2","user2","user2@gmail.com","1234","0666666","Rue malik","L1234","Admin");

        Mockito.when(receptionistRepository.findById(id)).thenReturn(Optional.of(receptionist));
        Mockito.when(receptionistRepository.save(receptionist)).thenReturn(receptionist_modify);

    Receptionist result = receptionistService.update_receptionist(receptionist_modify, id);

        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(receptionist_modify);
}
    @Test
    void delete_receptionist() {
        String id = "1L";
        receptionistService.delete_receptionist(id);
    }

    @Test
    void get_receptionist_by_email() {
        String email = "user1@mail.com";
        Receptionist receptionist = new Receptionist("1L","user1","user1","user1@gmail.com","1234","0666666","Rue malik","L1234","Admin");
        Mockito.when(receptionistRepository.findByEmail(email)).thenReturn(receptionist);
        Receptionist result = receptionistService.get_receptionist_by_email(email);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(receptionist);
    }

}