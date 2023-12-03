package com.example.employemangement.ws;


import com.example.employemangement.bean.Responsabilte;
import com.example.employemangement.service.ResponsabilteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/EmployeResponsabilte")
public class ResponsabilteProvided {
    @GetMapping(("/code/{code}"))
    public Responsabilte findByCode(@PathVariable String code) {
        return responsabilteService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return responsabilteService.deleteByCode(code);
    }

    public boolean existsByCode(@PathVariable String code) {
        return responsabilteService.existsByCode(code);
    }

    @GetMapping("/")
    public List<Responsabilte> findAll() {
        return responsabilteService.findAll();
    }

    @PutMapping("/upresponsabilte")
    public void update(@RequestBody Responsabilte responsabilte) {
        responsabilteService.update(responsabilte);
    }

    @PostMapping("/addResponsabilte")
    public void create(@RequestBody Responsabilte responsabilte) {
        responsabilteService.create(responsabilte);
    }

    @Autowired
    private ResponsabilteService responsabilteService;

}
