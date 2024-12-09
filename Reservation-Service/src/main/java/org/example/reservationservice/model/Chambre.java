package org.example.reservationservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    private String  numero;
    private int nombre_lits;
    private float prix;
    private String image;
    private String description;
    private Boolean disponible;
}
