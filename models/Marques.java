package com.example.gestion_flotte_avion_ws.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name="Marques")
@NoArgsConstructor
public class Marques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmarque", nullable = false)
    private Integer idMarque;

    @Column(name = "nommarque")
    private String marque;

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}

