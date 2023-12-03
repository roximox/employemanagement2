package com.example.employemangement.service;


import com.example.employemangement.bean.Responsabilte;
import com.example.employemangement.dao.MandatDao;
import com.example.employemangement.dao.ResponsabilteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsabilteService {

    public Responsabilte findByCode(String code) {
        return responsabilteDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        int mandatDeleted = mandatDao.deleteByResponsabilteCode(code);
        int respoDeleted = responsabilteDao.deleteByCode(code);
        return mandatDeleted + respoDeleted;
    }

    public boolean existsByCode(String code) {
        return responsabilteDao.existsByCode(code);
    }

    public List<Responsabilte> findAll() {
        return responsabilteDao.findAll();
    }

    public void update(Responsabilte responsabilte) {
        responsabilteDao.save(responsabilte);
    }


    public void create(Responsabilte responsabilte) {
        responsabilteDao.save(responsabilte);
    }

    @Autowired
    private ResponsabilteDao responsabilteDao;
    private MandatDao mandatDao;
}
