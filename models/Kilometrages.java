package com.example.gestion_flotte_avion_ws.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name="kilometrages")
@NoArgsConstructor
public class Kilometrages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idkilometrage", nullable = false)
    private Integer id;
    @Column(name = "idavion")
    private Integer idAvion;
    @Column(name="date")
    private Date date;
    @Column(name="debut_km")
    private Double debutKm;
    @Column(name = "fin_km")
    private Double finKm;
//    @ManyToOne
//    @JoinColumn(name = "idavion",referencedColumnName = "idavion")
//    private Avions avion;

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Double getDebutKm() {
        return debutKm;
    }

    public Double getFinKm() {
        return finKm;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDebutKm(Double debutKm) {
        this.debutKm = debutKm;
    }

    public void setFinKm(Double finKm) {
        this.finKm = finKm;
    }

    public Integer getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    //    public Avions getAvion() {
//        return avion;
//    }
//
//    public void setAvion(Avions avion) {
//        this.avion = avion;
//    }
}
