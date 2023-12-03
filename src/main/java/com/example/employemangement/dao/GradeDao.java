package com.example.employemangement.dao;


import com.example.employemangement.bean.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeDao extends JpaRepository<Grade,Long> {
    Grade findByCode(String code);
    int deleteByCode(String code);
    boolean existsByCode(String code);
    @Query("SELECT g.id, g.code, g.libelle FROM Grade g")
    List<Object[]> findAllGradesWithIdCodeLibelle();
}
