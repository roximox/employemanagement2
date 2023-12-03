package com.example.employemangement.dao;


import com.example.employemangement.bean.Mandat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MandatDao  extends JpaRepository<Mandat,Long> {
    Mandat findByCode(String code);
    int deleteByCode(String code);
    boolean existsByCode(String code);
    List<Mandat> findByEmployeCin(String cin, Sort sort);
    int deleteByEmployeCin(String cin);
    List<Mandat> findByResponsabilteCode(String code);
    List<Mandat> findByResponsabilteCodeAndEndDateGreaterThanEqual(String code, LocalDate localDate);
    Mandat findByEmployeCinAndEndDateBetween(String code, LocalDate minDate, LocalDate maxDate);
    Mandat findByEmployeCinAndStartDateLessThanAndEndDateGreaterThan(
            String cin, LocalDate monthEnd, LocalDate monthStart);
    int deleteByResponsabilteCode(String code);
}
