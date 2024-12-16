package com.example.receptionistservicee.repository;

import com.example.receptionistservicee.entity.Receptionist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
    Receptionist findByEmail(String email);

}
