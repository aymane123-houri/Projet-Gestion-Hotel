package com.example.receptionistservicee.controller;

import com.example.receptionistservicee.entity.Receptionist;
import com.example.receptionistservicee.service.ReceptionistService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Administrator")
public class ReceptionistController {

    public ReceptionistService receptionistService;

    public ReceptionistController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }

    @PostMapping
    public ResponseEntity<Receptionist> createUser(@RequestBody Receptionist receptionist) {
        return ResponseEntity.ok(receptionistService.create_Receptionist(receptionist));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receptionist> updateReceptionist(@RequestBody Receptionist receptionist,@PathVariable Long id) {
        return ResponseEntity.ok(receptionistService.update_receptionist(receptionist,id));
    }

     @DeleteMapping("/{id}")
    public void deleteReceptionist(@PathVariable Long id) {
        receptionistService.delete_receptionist(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receptionist> getReceptionist(@PathVariable Long id) {
        return ResponseEntity.ok(receptionistService.get_receptionist(id));
    }

    @GetMapping
    public ResponseEntity<List<Receptionist>> getAllReceptionist() {
        return ResponseEntity.ok(receptionistService.getAll_receptionist());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Map<String,String>> getUserByEmail(@PathVariable String email) {


        Receptionist receptionist = receptionistService.get_receptionist_by_email(email);
        if (receptionist!=null) {
            Map<String, String> infos_user = new HashMap<>();

            infos_user.put("email", receptionist.getEmail());
            infos_user.put("password", receptionist.getPassword());
            infos_user.put("scope", receptionist.getRole());
            return ResponseEntity.ok(infos_user);
        }
        return ResponseEntity.notFound().build();

    }

}
