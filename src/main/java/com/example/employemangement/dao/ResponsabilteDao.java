package com.example.employemangement.dao;


import com.example.employemangement.bean.Responsabilte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsabilteDao extends JpaRepository<Responsabilte,Long> {
    Responsabilte findByCode(String code);
    int deleteByCode(String code);
    boolean existsByCode(String code);
}
