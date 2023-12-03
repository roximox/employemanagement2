package com.example.employemangement.ws;


import com.example.employemangement.bean.Employe;
import com.example.employemangement.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/EmployeSalary")
public class EmployeProvided {
    @GetMapping("/cin/{cin}")
    public Employe findByCin(@PathVariable String cin) {
        return employeService.findByCin(cin);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return employeService.deleteByCin(cin);
    }


    @GetMapping("/ByEchelon")
    public List<Employe> findByEchelonCode(@PathVariable String code) {
        return employeService.findByEchelonCode(code);
    }

    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }

    @PostMapping("/newEmploye")
    public Employe create(@RequestBody Employe employe) {
        return employeService.create(employe);
    }


    @PutMapping("/upEmploye/{id}")
    public void updateEmploye(@RequestBody Employe updatedEmploye) {
        employeService.updateEmploye(updatedEmploye);


}


    @Autowired
    private EmployeService employeService;

}
