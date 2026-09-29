package com.example.GreenLog.Controller;

import com.example.GreenLog.Model.PlantationDrive;
import com.example.GreenLog.Service.PlantationDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantationDriveController {
    @Autowired
    PlantationDriveService service;
    @GetMapping("PlantationDrive")
    public List<PlantationDrive> getAllDrives() {
        return service.getAllDrives();
    }
    @PostMapping("PlantationDrive")
    public String addDrive(@RequestBody PlantationDrive drive) {
        return service.addDrive(drive);
    }
    @GetMapping("PlantationDrive/{id}")
    public PlantationDrive getDriveById(@PathVariable int id) {
        return service.getDriveById(id);
    }
    @PutMapping("PlantationDrive")
    public String updateDrive(@RequestBody PlantationDrive drive) {
        return service.updateDrive(drive);
    }
    @DeleteMapping("PlantationDrive/{id}")
    public String deleteDrive(@PathVariable int id) {
        return service.deleteDrive(id);
    }
    @DeleteMapping("PlantationDrive/clear")
    public String deleteAllDrives() {
        return service.deleteAllDrives();
    }





}
