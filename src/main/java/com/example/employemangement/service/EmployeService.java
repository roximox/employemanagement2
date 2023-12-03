package com.example.employemangement.service;


import com.example.employemangement.bean.*;
import com.example.employemangement.dao.EmployeDao;
import com.example.employemangement.dao.MandatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class  EmployeService {


    public EmployeService(MandatDao mandatDao) {
        this.mandatDao = mandatDao;
    }

    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }

    @Transactional
    public int deleteByCin(String cin) {
        // Récupérer l'employé en fonction du CIN
        Employe employe = employeDao.findByCin(cin);

        if (employe != null) {
            // Récupérer les mandats associés à l'employé en fonction de son CIN
            List<Mandat> mandats = mandatDao.findByEmployeCin(cin, Sort.unsorted());

            // Supprimer chaque mandat associé à l'employé
            for (Mandat mandat : mandats) {
                mandatDao.delete(mandat);
            }

            // Supprimer l'employé de la base de données
            employeDao.delete(employe);

            // Retourner 1 pour indiquer que la suppression a réussi
            return 1;
        } else {
            // Lever une exception car l'employé n'a pas été trouvé
            return 0;
        }
    }


    public List<Employe> findByEchelonCode(String code) {
        return employeDao.findByEchelonCode(code);
    }

    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    public Employe create(Employe employe) {
        Employe res = null;
        if (employe.getCin() != null) { // Vérifier si le cin n'est pas null
            res = employeDao.save(employe);
        }
        return res;
    }

    public void updateEmploye(Employe updatedEmploye) {
        // Récupérer l'employé existant à partir de la base de données en fonction de son ID
        Employe existingEmploye = employeDao.findById(updatedEmploye.getId()).orElse(null);

        if (existingEmploye != null) {
            // Mettre à jour les attributs de base de l'employé
            existingEmploye.setCin(updatedEmploye.getCin());
            existingEmploye.setName(updatedEmploye.getName());
            existingEmploye.setLastName(updatedEmploye.getLastName());
            existingEmploye.setSalaireBase(updatedEmploye.getSalaireBase());

            // Mettre à jour les attributs spécifiques de l'objet Grade
            Grade updatedGrade = updatedEmploye.getGrade();
            if (updatedGrade != null) {
                existingEmploye.getGrade().setCode(updatedGrade.getCode());
                existingEmploye.getGrade().setLibelle(updatedGrade.getLibelle());
                // Ajoutez d'autres attributs spécifiques de l'objet Grade au besoin
            }

            // Mettre à jour les attributs spécifiques de l'objet Echelle
            Echelle updatedEchelle = updatedEmploye.getEchelle();
            if (updatedEchelle != null) {
                existingEmploye.getEchelle().setCode(updatedEchelle.getCode());
                existingEmploye.getEchelle().setLibelle(updatedEchelle.getLibelle());
                existingEmploye.getEchelle().setGrade(updatedEchelle.getGrade());
                // Ajoutez d'autres attributs spécifiques de l'objet Echelle au besoin
            }

            // Mettre à jour les attributs spécifiques de l'objet Echelon
            Echelon updatedEchelon = updatedEmploye.getEchelon();
            if (updatedEchelon != null) {
                existingEmploye.getEchelon().setCode(updatedEchelon.getCode());
                existingEmploye.getEchelon().setLibelle(updatedEchelon.getLibelle());
                existingEmploye.getEchelon().setEchelle(updatedEchelon.getEchelle());
                // Ajoutez d'autres attributs spécifiques de l'objet Echelon au besoin
            }

            // Enregistrer les modifications dans la base de données
            employeDao.save(existingEmploye);
        } else {
            // Gérer le cas où l'employé n'est pas trouvé dans la base de données
            // Vous pouvez lever une exception ou gérer l'absence de l'employé selon vos besoins spécifiques
        }


}


    @Autowired
    private EmployeDao employeDao;
    private final MandatDao mandatDao;
}
