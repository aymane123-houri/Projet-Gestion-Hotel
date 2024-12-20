package com.example.reservationservicee.entity;


import com.example.reservationservicee.model.Chambre;
import com.example.reservationservicee.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private Long user_id;
    private Long chambre_id;
    private Date date_debut;
    private Date date_fin;
    private double montant_total;
    @Transient
    private User user;
    @Transient
    private Chambre chambre;


    /*public Reservation(Long id, Long user_id, Long chambre_id, Date date_debut, Date date_fin, double montant_total, User user, Chambre chambre) {
        this.id = id;
        this.user_id = user_id;
        this.chambre_id = chambre_id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.montant_total = montant_total;
        this.user = user;
        this.chambre = chambre;
    }

    public Reservation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getChambre_id() {
        return chambre_id;
    }

    public void setChambre_id(Long chambre_id) {
        this.chambre_id = chambre_id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public double getMontant_total() {
        return montant_total;
    }

    public void setMontant_total(double montant_total) {
        this.montant_total = montant_total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }*/
}
