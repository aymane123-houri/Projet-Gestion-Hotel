package com.example.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    private Long id;
    private String  numero;
    private int nombre_lits;
    private float prix;
    private String image;
    private String description;
    private Boolean disponible;

    private int adulte_capacite;

    private int enfant_capacite;

    private String type_lits;
}
