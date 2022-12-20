package com.example.gestion_flotte_avion_ws.models;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="modeles")
@NoArgsConstructor
public class Modeles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmodele", nullable = false)
    private Integer idModele;
    @Column(name="nommodele")
    private String modele;
//    @Column
//    private Integer idMarque;
    @ManyToOne(targetEntity = Marques.class)
    @JoinColumn(name = "idmarque",referencedColumnName = "idmarque")
    private Marques marque;

    public Integer getIdModele() {
        return idModele;
    }

    public void setIdModele(Integer idModele) {
        this.idModele = idModele;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

//    public Integer getIdMarque() {
//        return idMarque;
//    }

//    public void setIdMarque(Integer idMarque) {
//        this.idMarque = idMarque;
//    }

    public Marques getMarque() {
        return marque;
    }

    public void setMarque(Marques marque) {
        this.marque = marque;
    }
}
