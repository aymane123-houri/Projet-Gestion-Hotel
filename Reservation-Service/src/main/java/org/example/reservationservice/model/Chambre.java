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

private Long numero;
private String type_chambre ;
private Float prix ;
private Boolean disponible ;
}
