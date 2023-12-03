package com.example.employemangement.dao;



import com.example.employemangement.bean.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeDao extends JpaRepository<Employe,Long> {
    Employe findByCin(String cin);
    int deleteByCin(String cin);
    List<Employe> findByEchelonCode(String code);
}
