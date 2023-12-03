package com.example.employemangement.bean;

import com.example.employemangement.service.DateParser;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class
Mandat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Responsabilte responsabilte;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Employe employe;
    private double prime;
    private LocalDate startDate;
    private LocalDate endDate;

    public void setStartDate(String startDate) {
        this.startDate = DateParser.parseDate(startDate);
    }

    public void setEndDate(String endDate) {
        this.endDate = DateParser.parseDate(endDate);
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

    public Responsabilte getResponsabilte() {
        return responsabilte;
    }

    public void setResponsabilte(Responsabilte responsabilte) {
        this.responsabilte = responsabilte;
    }


    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

   /* @JsonCreator
    public static Mandat fromString(String code) {
        Mandat mandat = new Mandat();
        mandat.setCode(code);
        return mandat;
    }*/

  /*  @JsonValue
    public String toJson() {
        return this.code;
    }*/
}
