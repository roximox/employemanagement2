package com.example.employemangement.service;

import com.example.employemangement.bean.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SauvgardeEntites {
    @PersistenceContext
    private EntityManager entityManager;

    public void sauvegarderEmploye(Employe employe) {
        entityManager.persist(employe);
    }

    public void sauvegarderEchelon(Echelon echelon) {
        entityManager.persist(echelon);
    }

    public void sauvegarderEchelle(Echelle echelle) {
        entityManager.persist(echelle);
    }

    public void sauvegarderGrade(Grade grade) {
        entityManager.persist(grade);
    }

    public void sauvegarderResponsabilte(Responsabilte responsabilte) {
        entityManager.persist(responsabilte);
    }
}
