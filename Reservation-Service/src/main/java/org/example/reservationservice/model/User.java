package org.example.reservationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String nom;
    private String prenom ;
    private String email ;
    private Long telephone ;
    private String adresse ;
    private String role;
    private String CIN;
    private String password;
}
