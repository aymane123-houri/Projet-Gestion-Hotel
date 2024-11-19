package org.example.reservationservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.reservationservice.model.Chambre;
import org.example.reservationservice.model.User;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long chambreId;
    private Date date_debut;
    private Date date_fin;
    private String status;
    private Long montant_total;



    @Transient
    private User user;

    @Transient
    private Chambre chambre;

}
