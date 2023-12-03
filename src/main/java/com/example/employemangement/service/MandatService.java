package com.example.employemangement.service;


import com.example.employemangement.bean.Mandat;
import com.example.employemangement.dao.MandatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MandatService {

    public Mandat findByCode(String code) {
        return mandatDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return mandatDao.deleteByCode(code);
    }

    public boolean existsByCode(String code) {
        return mandatDao.existsByCode(code);
    }

    public List<Mandat> findByEmployeCin(String cin, Sort sort) {
        return mandatDao.findByEmployeCin(cin, sort);
    }

    public int deleteByEmployeCin(String cin) {
        return mandatDao.deleteByEmployeCin(cin);
    }

    public List<Mandat> findByResponsabilteCode(String code) {
        return mandatDao.findByResponsabilteCode(code);
    }

    public List<Mandat> findByResponsabilteCodeAndEndDateGreaterThanEqual(String code, LocalDate localDate) {
        return mandatDao.findByResponsabilteCodeAndEndDateGreaterThanEqual(code, localDate);
    }

    public Mandat findByEmployeCinAndEndDateBetween(String code, LocalDate minDate, LocalDate maxDate) {
        return mandatDao.findByEmployeCinAndEndDateBetween(code, minDate, maxDate);
    }

    public Mandat findByEmployeCinAndStartDateLessThanAndEndDateGreaterThan(String cin, LocalDate monthEnd, LocalDate monthStart) {
        return mandatDao.findByEmployeCinAndStartDateLessThanAndEndDateGreaterThan(cin, monthEnd, monthStart);
    }

    public void create(Mandat mandat) {
        mandatDao.save(mandat);
    }

    public int deleteByResponsabilteCode(String code) {
        return mandatDao.deleteByResponsabilteCode(code);
    }

    public List<Mandat> findAll() {
        return mandatDao.findAll();
    }

    public int updatePrime(Long id, double prime) {
        Mandat mandat = mandatDao.findById(id).orElse(null);
        if (mandat == null) return -1;
        mandat.setPrime(prime);
        mandatDao.save(mandat);
        return 1;
    }

    @Autowired
    private MandatDao mandatDao;
}
