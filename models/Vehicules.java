package com.example.gestion_flotte_avion_ws.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "avions")
@NoArgsConstructor
public class Avions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idavion", nullable = false)
    private Integer idAvion;
    @Column(name = "matricule", nullable = false)
    private String matricule;
    /*@Column(name = "idmodele")
    private Integer idModele;*/
    /*@OneToMany(targetEntity = Kilometrages.class,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "idavion",referencedColumnName = "idavion")
    private List<Kilometrages> kilometrages=new ArrayList<Kilometrages>();*/
    @ManyToOne(targetEntity = Modeles.class)
    @JoinColumn(name = "idmodele", referencedColumnName = "idmodele")
    private Modeles modele;

    public Integer getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Modeles getModele() {
        return modele;
    }

    public void setModele(Modeles modele) {
        this.modele = modele;
    }
/*public int getIdModele() {
        return idModele;
    }

    public void setIdModele(Integer idModele) {
        this.idModele = idModele;
    }*/

    /*public List<Kilometrages> getKilometrages() {
        return kilometrages;
    }

    public void setKilometrages(List<Kilometrages> kilometrages) {
        this.kilometrages = kilometrages;
    }*/

    @Override
    public String toString() {
        return "Avions{" +
                "idAvion=" + idAvion +
                ", matricule='" + matricule + '\'' +
                ", idModele=" + this.modele +
                '}';
    }
}
