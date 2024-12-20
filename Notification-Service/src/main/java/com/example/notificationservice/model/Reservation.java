package com.example.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {


    private Long id;
    private Long user_id;
    private Long chambre_id;
    private Date date_debut;
    private Date date_fin;
    private double montant_total;
    private User user;
    private Chambre chambre;
}
