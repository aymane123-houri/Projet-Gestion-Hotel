package com.example.receptionistservicee.service;

import com.example.receptionistservicee.entity.Receptionist;
import com.example.receptionistservicee.repository.ReceptionistRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionistService {

    private final ReceptionistRepository receptionistRepository;

    public ReceptionistService(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;

    }

    public Receptionist create_Receptionist(Receptionist receptionist) {
        return receptionistRepository.save(receptionist);
    }

    public List<Receptionist> getAll_receptionist() {
        return receptionistRepository.findAll();
    }
    public Receptionist get_receptionist(String id) {
        return receptionistRepository.findById(id).orElse(null);
    }

    public Receptionist update_receptionist(Receptionist receptionist, String id) {
        return receptionistRepository.findById(id).map(receptionist1 -> {
            receptionist1.setNom(receptionist.getNom());
            receptionist1.setPrenom(receptionist.getPrenom());
            receptionist1.setEmail(receptionist.getEmail());
            receptionist1.setRole(receptionist.getRole());
            receptionist1.setTelephone(receptionist.getTelephone());
            receptionist1.setCni(receptionist.getCni());
            receptionist1.setAdresse(receptionist.getAdresse());
            return receptionistRepository.save(receptionist1);
            }

        ).orElseThrow((() -> new RuntimeException("user not found")));
    }



    public void delete_receptionist(String id) {
        receptionistRepository.deleteById(id);
    }


    public Receptionist get_receptionist_by_email(String email) {

        return receptionistRepository.findByEmail(email);
    }
}
