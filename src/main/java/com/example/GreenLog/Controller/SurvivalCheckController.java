package com.example.GreenLog.Controller;

import com.example.GreenLog.Model.SurvivalCheck;
import com.example.GreenLog.Service.SurvivalCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurvivalCheckController {
    @Autowired
    SurvivalCheckService service;

    @GetMapping("SurvivalCheck")
    public List<SurvivalCheck> getAllChecks() {
        return service.getAllChecks();
    }
    @PostMapping("SurvivalCheck")
    public String addCheck(@RequestBody SurvivalCheck check) {
        return service.addCheck(check);
    }
    @GetMapping("SurvivalCheck/{id}")
    public SurvivalCheck getCheckById(@PathVariable int id) {
        return service.getCheckById(id);
    }
    @PutMapping("SurvivalCheck")
    public String updateCheck(@RequestBody SurvivalCheck check) {
        return service.updateCheck(check);
    }

    @DeleteMapping("SurvivalCheck/{id}")
    public String deleteCheck(@PathVariable int id) {
        return service.deleteCheck(id);
    }

    @DeleteMapping("SurvivalCheck/clear")
    public String deleteAllChecks() {
        return service.deleteAllChecks();
    }
    @GetMapping("SurvivalCheck/SurvivalRate/Drive/{driveId}")
    public double getSurvivalRateByDrive(@PathVariable int driveId) {
        return service.getSurvivalRateByDrive(driveId);
    }

    @GetMapping("SurvivalCheck/SurvivalRate/Species/{species}")
    public double getSurvivalRateBySpecies(@PathVariable String species) {
        return service.getSurvivalRateBySpecies(species);
    }
}
