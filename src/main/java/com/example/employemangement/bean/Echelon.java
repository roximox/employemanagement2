package com.example.employemangement.bean;


import jakarta.persistence.*;

@Entity
public class Echelon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    private int delai = 0;
    private int prime = 0;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Echelle echelle;
    @OneToOne
    private Echelle echelleSuiv;
    @OneToOne
    private Echelle echellePrec;


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

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    public Echelle getEchelle() {
        return echelle;
    }

    public void setEchelle(Echelle echelle) {
        this.echelle = echelle;
    }

    public Echelle getEchelleSuiv() {
        return echelleSuiv;
    }

    public void setEchelleSuiv(Echelle echelleSuiv) {
        this.echelleSuiv = echelleSuiv;
    }

    public Echelle getEchellePrec() {
        return echellePrec;
    }

    public void setEchellePrec(Echelle echellePrec) {
        this.echellePrec = echellePrec;
    }
}
