package com.example.reservationservicee.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNombre_lits() {
        return nombre_lits;
    }

    public void setNombre_lits(int nombre_lits) {
        this.nombre_lits = nombre_lits;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public int getAdulte_capacite() {
        return adulte_capacite;
    }

    public void setAdulte_capacite(int adulte_capacite) {
        this.adulte_capacite = adulte_capacite;
    }

    public int getEnfant_capacite() {
        return enfant_capacite;
    }

    public void setEnfant_capacite(int enfant_capacite) {
        this.enfant_capacite = enfant_capacite;
    }

    public String getType_lits() {
        return type_lits;
    }

    public void setType_lits(String type_lits) {
        this.type_lits = type_lits;
    }

    public Chambre(Long id, String numero, int nombre_lits, float prix, String image, String description, Boolean disponible, int adulte_capacite, int enfant_capacite, String type_lits) {
        this.id = id;
        this.numero = numero;
        this.nombre_lits = nombre_lits;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.disponible = disponible;
        this.adulte_capacite = adulte_capacite;
        this.enfant_capacite = enfant_capacite;
        this.type_lits = type_lits;
    }

    public Chambre() {
    }
}
