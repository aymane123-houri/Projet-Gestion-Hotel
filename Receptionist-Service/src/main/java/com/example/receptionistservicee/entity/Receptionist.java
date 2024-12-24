package com.example.receptionistservicee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "receptionist")
public class Receptionist {

    private String _id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private String adresse;
    private String cni;
    private String role;

    // Constructeurs

}
