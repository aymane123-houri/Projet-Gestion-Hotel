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
    private String nom;
    private String prenom ;
    private String email ;
    private String  telephone ;
    private String adresse ;
    private String cni;
    private String password;
}
