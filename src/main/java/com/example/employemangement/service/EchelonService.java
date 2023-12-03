package com.example.employemangement.service;


import com.example.employemangement.bean.Echelle;
import com.example.employemangement.bean.Echelon;
import com.example.employemangement.bean.Grade;
import com.example.employemangement.dao.EchelleDao;
import com.example.employemangement.dao.EchelonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EchelonService {

    public List<Echelon> findAll() {
        return echelonDao.findAll();
    }

    public Echelon findByCode(String code) {
        return echelonDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return echelonDao.deleteByCode(code);
    }

    public boolean existsByCode(String code) {
        return echelonDao.existsByCode(code);
    }

    public List<Echelon> findByEchelleCode(String code) {
        return echelonDao.findByEchelleCode(code);
    }

    public Echelon create(Echelon echelon) {
        Echelon res = null;
        if (echelon.getCode() != null) { // Vérifier si le code n'est pas null
            res = echelonDao.save(echelon);
        }
        return res;
    }

    public void updateEchelon(Echelon updatedEchelon) {
        // Récupérer l'employé existant à partir de la base de données en fonction de son ID
        Echelon existingEchelon = echelonDao.findByCode(updatedEchelon.getCode());

        if (existingEchelon != null) {
            // Mettre à jour les attributs de base de l'employé
            existingEchelon.setCode(updatedEchelon.getCode());
            existingEchelon.setLibelle(updatedEchelon.getLibelle());


            // Mettre à jour les attributs spécifiques de l'objet Grade
            Echelle updatedEchelle = updatedEchelon.getEchelle();
            if (updatedEchelle != null) {
                existingEchelon.getEchelle().setCode(updatedEchelle.getCode());
                existingEchelon.getEchelle().setLibelle(updatedEchelle.getLibelle());
                // Ajoutez d'autres attributs spécifiques de l'objet Grade au besoin
            }


            // Enregistrer les modifications dans la base de données
            echelonDao.save(existingEchelon);
        } else {
            // Gérer le cas où l'employé n'est pas trouvé dans la base de données
            // Vous pouvez lever une exception ou gérer l'absence de l'employé selon vos besoins spécifiques
        }

    }

        @Autowired
    private EchelonDao echelonDao;
    private EchelleDao echelleDao;
}
