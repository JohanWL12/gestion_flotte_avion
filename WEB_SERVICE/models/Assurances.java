<<<<<<< Updated upstream
package com.example.gestion_flotte.models;
=======
package com.example.gestion_flotte_avion_ws.models;

import com.example.gestion_flotte_avion_ws.models.Avions;
>>>>>>> Stashed changes

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Assurances")
@NoArgsConstructor
public class Assurances {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idassurance",nullable = false)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "idavion",referencedColumnName = "idavion")
    Avions avion;
//    @Column(name = "idavion")
//    Integer idAvion;
    @Column(name="datepayement")
    Timestamp datePayement;
    @Column(name="dateexpiration")
    Timestamp dateExpiration;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getIdAvion() {
//        return idAvion;
//    }
//
//    public void setIdAvion(Integer idAvion) {
//        this.idAvion = idAvion;
//    }
    public Avions getAvion() {
        return avion;
    }

    public void setAvion(Avions avion) {
        this.avion = avion;
    }

    public Timestamp getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Timestamp datePayement) {
        this.datePayement = datePayement;
    }

    public Timestamp getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Timestamp dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
