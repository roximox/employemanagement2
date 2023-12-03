package com.example.employemangement.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;

@Entity
public class Responsabilte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Echelon echelon;
    private double prime = 0;

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Echelon getEchelon() {
        return echelon;
    }

    public void setEchelon(Echelon echelon) {
        this.echelon = echelon;
    }

   /* @JsonCreator
    public static Responsabilte fromString(String code) {
        Responsabilte responsabilite = new Responsabilte();
        responsabilite.setCode(code);
        return responsabilite;
    }

    @JsonValue
    public String toJson() {
        return this.code;
    }*/
}
