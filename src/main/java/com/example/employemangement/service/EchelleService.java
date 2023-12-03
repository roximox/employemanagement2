package com.example.employemangement.service;


import com.example.employemangement.bean.Echelle;
import com.example.employemangement.bean.Echelon;
import com.example.employemangement.bean.Employe;
import com.example.employemangement.bean.Grade;
import com.example.employemangement.dao.EchelleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EchelleService {

    public Echelle findByCode(String code) {
        return echelleDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return echelleDao.deleteByCode(code);
    }

    public List<Echelle> findByGradeCode(String code) {
        return echelleDao.findByGradeCode(code);
    }

    public boolean existsByCode(String code) {
        return echelleDao.existsByCode(code);
    }


    public List<Echelle> findAll() {
        return echelleDao.findAll();
    }

    public Echelle create(Echelle echelle) {
        Echelle res = null;
        if (echelle.getCode() != null) { // Vérifier si le cin n'est pas null
            res = echelleDao.save(echelle);
        }
        return res;

    }

    public void updateEchelle(Echelle updatedEchelle) {
        // Récupérer l'employé existant à partir de la base de données en fonction de son ID
        Echelle existingEchelle = echelleDao.findByCode(updatedEchelle.getCode());

        if (existingEchelle != null) {
            // Mettre à jour les attributs de base de l'employé
            existingEchelle.setCode(updatedEchelle.getCode());
            existingEchelle.setLibelle(updatedEchelle.getLibelle());


            // Mettre à jour les attributs spécifiques de l'objet Grade
            Grade updatedGrade = updatedEchelle.getGrade();
            if (updatedGrade != null) {
                existingEchelle.getGrade().setCode(updatedGrade.getCode());
                existingEchelle.getGrade().setLibelle(updatedGrade.getLibelle());
                // Ajoutez d'autres attributs spécifiques de l'objet Grade au besoin
            }


            // Enregistrer les modifications dans la base de données
            echelleDao.save(existingEchelle);
        } else {
            // Gérer le cas où l'employé n'est pas trouvé dans la base de données
            // Vous pouvez lever une exception ou gérer l'absence de l'employé selon vos besoins spécifiques
        }



    }
    @Autowired
    private EchelleDao echelleDao;
}
