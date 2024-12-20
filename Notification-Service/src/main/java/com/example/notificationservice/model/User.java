package com.example.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    private Long id;
    private String nom;
    private String prenom ;
    private String email ;
    private String telephone ;
    private String adresse ;
    private String cni;
    private String password;
}
