package com.example.gestion_flotte.models;

import javax.persistence.*;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "tokens")
@NoArgsConstructor
public class Tokens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtoken", nullable = false)
    private Integer idToken;
    @Column(name = "iduser",insertable = false,updatable = false)
    private Integer idUser;
    @Column(name = "token")
    private String token;
    @Column(name = "date_generation")
    private Timestamp dateGeneration;
    @Column(name = "date_expiration")
    private Timestamp dateExpiration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser",nullable = false)
    private Users user;

    public Integer getIdToken() {
        return idToken;
    }

    public void setIdToken(Integer idToken) {
        this.idToken = idToken;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getDateGeneration() {
        return dateGeneration;
    }

    public void setDateGeneration(Timestamp dateGeneration) {
        this.dateGeneration = dateGeneration;
    }

    public Timestamp getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Timestamp dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
