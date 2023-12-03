package com.example.employemangement.service;


import com.example.employemangement.bean.Grade;
import com.example.employemangement.dao.GradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static org.aspectj.util.LangUtil.isEmpty;


@Service
public class GradeService {
    @Autowired
    private GradeDao gradeDao;

    private GradeService gradeService;

    public Grade findByCode(String code) {
        return gradeDao.findByCode(code);
    }

    public Grade deleteById(Long id) {
        // Trouver l'entité par son ID
        Optional<Grade> gradeOptional = gradeDao.findById(id);

        if (gradeOptional.isPresent()) {
            // L'entité existe, récupérez-la
            Grade gradeToDelete = gradeOptional.get();

            // Supprimer l'entité
            gradeDao.deleteById(id);

            return gradeToDelete;
        } else {
            // L'entité avec l'ID spécifié n'a pas été trouvée, vous pouvez gérer cela en fonction de vos besoins.
            // Par exemple, throw new EntityNotFoundException("Grade avec l'ID " + id + " non trouvé.");
            return null; // Ou retourner une valeur spéciale indiquant que rien n'a été supprimé
        }
    }


    public boolean existsByCode(String code) {
        return gradeDao.existsByCode(code);
    }

    public List<Object[]> findAll() {
        return gradeDao.findAllGradesWithIdCodeLibelle();
    }

    public Grade create(Grade grade) {
        // Modification pour ajouter les attributs manquants
        // Exemple :
        grade.setId(grade.getId()); // Remplacer generateId() par votre méthode pour générer un nouvel ID si nécessaire
        grade.setCode(grade.getCode());
        grade.setLibelle(grade.getLibelle());
        return gradeDao.save(grade);
    }

    public int run(Grade newGrade) {
        String code = newGrade.getCode();
        if (isEmpty(code)) return -1; // grad's code is required

        Grade oldGrad = gradeService.findByCode(code);
        if (oldGrad == null) return -2; // targeted grad have to be in database

        String libelle = newGrade.getLibelle();
        if (!libelle.isBlank()) {
            oldGrad.setLibelle(libelle);
            gradeService.edit(oldGrad);
        }
        return 1;
    }
    public void edit(Grade newGrade) {
        // Récupérer l'entité existante par ID depuis la base de données
        Optional<Grade> existingGradeOptional = gradeDao.findById(newGrade.getId());

        if (existingGradeOptional.isPresent()) {
            // L'entité existe, récupérez-la
            Grade existingGrade = existingGradeOptional.get();

            // Mettez à jour les attributs nécessaires
            existingGrade.setCode(newGrade.getCode());
            existingGrade.setLibelle(newGrade.getLibelle());

            // Enregistrez les modifications
            gradeDao.save(existingGrade);
        } else {
            // L'entité avec l'ID spécifié n'a pas été trouvée, vous pouvez gérer cela en fonction de vos besoins.
            // Vous pouvez lever une exception, logger un avertissement, etc.
            // Par exemple, throw new EntityNotFoundException("Grade avec l'ID " + newGrade.getId() + " non trouvé.");
        }
    }

}
