package com.example.employemangement.dao;

import com.example.employemangement.bean.Echelon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EchelonDao  extends JpaRepository<Echelon,Long> {
    Echelon findByCode(String code);
    int deleteByCode(String code);
    boolean existsByCode(String code);
    List<Echelon> findByEchelleCode(String code);
}



