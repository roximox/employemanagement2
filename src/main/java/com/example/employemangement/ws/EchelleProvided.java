package com.example.employemangement.ws;


import com.example.employemangement.bean.Echelle;
import com.example.employemangement.service.EchelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/EmployeEchelle")
public class EchelleProvided {

    @GetMapping("/code/{code}")
    public Echelle findByCode(@PathVariable String code) {
        return echelleService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return echelleService.deleteByCode(code);
    }

    @GetMapping("/grade/code/{code}")
    public List<Echelle> findByGradeCode(@PathVariable String code) {
        return echelleService.findByGradeCode(code);
    }

    @GetMapping("/")
    public List<Echelle> findAll() {
        return echelleService.findAll();
    }


    @PostMapping("/addEchelle")
    public Echelle create(@RequestBody Echelle echelle) {
        return echelleService.create(echelle);
    }


    @PutMapping("/upEchelle/{code}")
    public void updateEchelle(@RequestBody Echelle updatedEchelle) {
        echelleService.updateEchelle(updatedEchelle);
    }




    @Autowired
    private EchelleService echelleService;
}
