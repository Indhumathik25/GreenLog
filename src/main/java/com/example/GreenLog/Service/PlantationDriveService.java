package com.example.GreenLog.Service;

import com.example.GreenLog.Model.PlantationDrive;
import com.example.GreenLog.Repository.PlantationDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlantationDriveService {
    @Autowired
    PlantationDriveRepository repository;

    public List<PlantationDrive> getAllDrives() {
        return repository.findAll();
    }

    public String addDrive(PlantationDrive drive) {
        repository.save(drive);
        return "Plantation Drive added successfully";
    }

    public PlantationDrive getDriveById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String updateDrive(PlantationDrive drive) {
        repository.save(drive);
        return "Plantation Drive updated successfully";
    }

    public String deleteDrive(int id) {
        repository.deleteById(id);
        return "Plantation Drive deleted successfully";
    }

    public String deleteAllDrives() {
        repository.deleteAll();
        return "All Plantation Drive deleted successfully";
    }
}
