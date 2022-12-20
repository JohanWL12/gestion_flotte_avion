package com.example.gestion_flotte.models;

import javax.persistence.*;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "images")
@NoArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimage",nullable = false)
    private Integer idImage;
    @Column(name = "idavion",nullable = false)
    private Integer idAvion;
    @Column(name = "base",nullable = false)
    private byte[] base;
    @Column(name = "datechangement",nullable = false)
    private Timestamp dateChangement;

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public Integer getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public byte[] getBase() {
        return base;
    }

    public void setBase(byte[] base) {
        this.base = base;
    }

    public Timestamp getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(Timestamp dateChangement) {
        this.dateChangement = dateChangement;
    }
}
