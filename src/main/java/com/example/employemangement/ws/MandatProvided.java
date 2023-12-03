package com.example.employemangement.ws;


import com.example.employemangement.bean.Mandat;
import com.example.employemangement.service.MandatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/EmployeMandat")
public class MandatProvided {

    @GetMapping("/code/{code}")
    public Mandat findByCode(@PathVariable String code) {
        return mandatService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return mandatService.deleteByCode(code);
    }


    @GetMapping("/Employe/cin/{cin}")
    public List<Mandat> findByEmployeCin(@PathVariable String cin, Sort sort) {
        return mandatService.findByEmployeCin(cin, sort);
    }

    @Transactional
    @DeleteMapping("/Employe/cin/{cin}")
    public int deleteByEmployeCin(@PathVariable String cin) {
        return mandatService.deleteByEmployeCin(cin);
    }

    @GetMapping("/Responsabilte/code/{code}")
    public List<Mandat> findByResponsabilteCode(@PathVariable String code) {
        return mandatService.findByResponsabilteCode(code);
    }

    @GetMapping("/Responsabilte/code/{code}/Date/{date}")
    public List<Mandat> findByResponsabilteCodeAndEndDateGreaterThanEqual(@PathVariable String code, @PathVariable LocalDate localDate) {
        return mandatService.findByResponsabilteCodeAndEndDateGreaterThanEqual(code, localDate);
    }

    @GetMapping("/ListEmploye/cin/{cin}")
    public Mandat findByEmployeCinAndEndDateBetween(@PathVariable String code, @PathVariable LocalDate minDate, @PathVariable LocalDate maxDate) {
        return mandatService.findByEmployeCinAndEndDateBetween(code, minDate, maxDate);
    }

    @PostMapping("/addMandat")
    public void create(@RequestBody Mandat mandat) {
        mandatService.create(mandat);
    }

    public Mandat findByEmployeCinAndStartDateLessThanAndEndDateGreaterThan(String cin, LocalDate monthEnd, LocalDate monthStart) {
        return mandatService.findByEmployeCinAndStartDateLessThanAndEndDateGreaterThan(cin, monthEnd, monthStart);
    }

    @Transactional
    @DeleteMapping("/Responsabilte/code/{code}")
    public int deleteByResponsabilteCode(@PathVariable String code) {
        return mandatService.deleteByResponsabilteCode(code);
    }

    @GetMapping("/")
    public List<Mandat> findAll() {
        return mandatService.findAll();
    }

    @PutMapping("/upPrime")
    public int updatePrime(@PathVariable Long id, @PathVariable double prime) {
        return mandatService.updatePrime(id, prime);
    }

    @Autowired
    private MandatService mandatService;
}
