package com.example.employemangement.ws;


import com.example.employemangement.bean.Grade;
import com.example.employemangement.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/EmployeGrade")
public class GradeProvided {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/code/{code}")
    public Grade findByCode(@PathVariable String code) {
        return gradeService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("/id/{id}")
    public Grade deleteById(@PathVariable Long id) {
        return gradeService.deleteById(id);
    }


    public boolean existsByCode(@PathVariable String code) {
        return gradeService.existsByCode(code);
    }

    @GetMapping("/")
    public List<Object[]> findAll() {
        return gradeService.findAll();
    }

    @PostMapping("/addGrade")
    public Grade create(@RequestBody Grade grade) {
        return gradeService.create(grade);
    }

    @PutMapping("/runGrade")
    public int run(@RequestBody Grade newGrade) {
        return gradeService.run(newGrade);
    }

    @PutMapping("/upGrade/{id}")
    public void edit(@RequestBody Grade newGrade) {
        gradeService.edit(newGrade);
    }
}
