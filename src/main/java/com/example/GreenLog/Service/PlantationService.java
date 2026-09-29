package com.example.GreenLog.Service;

import com.example.GreenLog.Model.Plantation;
import com.example.GreenLog.Model.SurvivalCheck;
import com.example.GreenLog.Repository.PlantationRepository;
import com.example.GreenLog.Repository.PlantationDriveRepository;
import com.example.GreenLog.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantationService {

    @Autowired
    PlantationRepository repository;

    @Autowired
    PlantationDriveRepository driveRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    public List<Plantation> getAllPlantations() {
        return repository.findAll();
    }

    public String addPlantation(Plantation plantation) {

        if (plantation.getDrive() != null) {
            plantation.setDrive(
                    driveRepository.findById(plantation.getDrive().getId()).orElse(null)
            );
        }

        if (plantation.getVolunteer() != null) {
            plantation.setVolunteer(
                    volunteerRepository.findById(plantation.getVolunteer().getId()).orElse(null)
            );
        }

        repository.save(plantation);

        return "Plantation added successfully";
    }

    public Plantation getPlantationById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String updatePlantation(Plantation plantation) {

            if (plantation.getDrive() != null) {

                plantation.setDrive(
                        driveRepository
                                .findById(plantation.getDrive().getId())
                                .orElse(null)
                );
            }

            if (plantation.getVolunteer() != null) {

                plantation.setVolunteer(
                        volunteerRepository
                                .findById(plantation.getVolunteer().getId())
                                .orElse(null)
                );
            }

            repository.save(plantation);

            return "Plantation updated successfully";
        }

    public String deletePlantation(int id) {
        repository.deleteById(id);
        return "Plantation deleted successfully";
    }

    public String deleteAllPlantations() {
        repository.deleteAll();
        return "All Plantations deleted successfully";
    }

}