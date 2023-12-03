package com.example.employemangement.bean;

import jakarta.persistence.*;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;
    private String name;
    private String lastName;
    private int salaireBase;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Echelle echelle;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Echelon echelon;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Grade grade;

    public Employe() {
    }

    public Employe(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(int salaireBase) {
        this.salaireBase = salaireBase;
    }

    public Echelle getEchelle() {
        return echelle;
    }

    public void setEchelle(Echelle echelle) {
        this.echelle = echelle;
    }

    public Echelon getEchelon() {
        return echelon;
    }

    public void setEchelon(Echelon echelon) {
        this.echelon = echelon;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
