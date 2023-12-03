package com.example.employemangement.ws;

import com.example.employemangement.bean.Echelon;
import com.example.employemangement.dao.EchelonDao;
import com.example.employemangement.service.EchelonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/EmployeEchelon")
public class EchelonProvided {

    @GetMapping("/")
    public List<Echelon> findAll() {
        return echelonService.findAll();
    }

    @GetMapping("/code/{code}")
    public Echelon findByCode(@PathVariable String code) {
        return echelonService.findByCode(code);
    }


    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return echelonService.deleteByCode(code);
    }

    @GetMapping("/echelle/code/{code}")
    public List<Echelon> findByEchelleCode(@PathVariable String code) {
        return echelonService.findByEchelleCode(code);
    }

    @PostMapping("/addEchelon")
    public void create(@RequestBody Echelon echelon) {
        echelonService.create(echelon);
    }

    @PutMapping("/upEchelon")
    public void updateEchelon(@RequestBody Echelon updatedEchelon) {
        echelonService.updateEchelon(updatedEchelon);
    }




    @Autowired
    private EchelonService echelonService;

}
