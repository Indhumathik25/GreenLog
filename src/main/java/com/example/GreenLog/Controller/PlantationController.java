package com.example.GreenLog.Controller;

import com.example.GreenLog.Model.Plantation;
import com.example.GreenLog.Model.SurvivalCheck;
import com.example.GreenLog.Service.PlantationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantationController {
    @Autowired
    PlantationService service;
    @GetMapping("Plantation")
    public List<Plantation> getAllPlantations() {
        return service.getAllPlantations();
    }
    @PostMapping("Plantation")
    public String addPlantation(@RequestBody Plantation plantation) {
        return service.addPlantation(plantation);
    }
    @GetMapping("Plantation/{id}")
    public Plantation getPlantationById(@PathVariable int id) {
        return service.getPlantationById(id);
    }
    @PutMapping("Plantation")
    public String updatePlantation(@RequestBody Plantation plantation) {
        return service.updatePlantation(plantation);
    }

    @DeleteMapping("Plantation/{id}")
    public String deletePlantation(@PathVariable int id) {
        return service.deletePlantation(id);
    }
    @DeleteMapping("Plantation/clear")
    public String deleteAllPlantations() {
        return service.deleteAllPlantations();
    }


}
