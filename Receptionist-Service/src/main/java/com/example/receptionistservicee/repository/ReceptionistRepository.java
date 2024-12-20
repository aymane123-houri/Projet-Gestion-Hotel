package com.example.receptionistservicee.repository;

import com.example.receptionistservicee.entity.Receptionist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceptionistRepository extends MongoRepository<Receptionist,String > {
    Receptionist findByEmail(String email);

}
