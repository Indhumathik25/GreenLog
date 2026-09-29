package com.example.GreenLog.Service;

import com.example.GreenLog.Model.SurvivalCheck;
import com.example.GreenLog.Model.Plantation;
import com.example.GreenLog.Repository.SurvivalCheckRepository;
import com.example.GreenLog.Repository.PlantationRepository;
import com.example.GreenLog.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurvivalCheckService {

    @Autowired
    SurvivalCheckRepository repository;

    @Autowired
    PlantationRepository plantationRepository;

    @Autowired
    VolunteerRepository volunteerRepository;


    public List<SurvivalCheck> getAllChecks() {
        return repository.findAll();
    }


    public String addCheck(SurvivalCheck check) {

        if (check.getPlantation() != null) {

            check.setPlantation(
                    plantationRepository.findById(
                            check.getPlantation().getId()
                    ).orElse(null)
            );
        }

        if (check.getVolunteer() != null) {

            check.setVolunteer(
                    volunteerRepository.findById(
                            check.getVolunteer().getId()
                    ).orElse(null)
            );
        }

        repository.save(check);

        return "Survival Check added successfully";
    }


    public SurvivalCheck getCheckById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String updateCheck(SurvivalCheck check) {

        if (check.getPlantation() != null) {

            check.setPlantation(
                    plantationRepository
                            .findById(check.getPlantation().getId())
                            .orElse(null)
            );
        }

        if (check.getVolunteer() != null) {

            check.setVolunteer(
                    volunteerRepository
                            .findById(check.getVolunteer().getId())
                            .orElse(null)
            );
        }

        repository.save(check);

        return "Survival Check updated successfully";
    }


    public String deleteCheck(int id) {
        repository.deleteById(id);
        return "Survival Check deleted successfully";
    }


    public String deleteAllChecks() {
        repository.deleteAll();
        return "All Survival Checks deleted successfully";
    }


    public double getSurvivalRateByDrive(int driveId) {

        List<Plantation> plantations =
                plantationRepository.findAll();

        List<SurvivalCheck> checks =
                repository.findAll();

        int totalTrees = 0;
        int aliveTrees = 0;


        for (Plantation plantation : plantations) {

            if (plantation.getDrive() != null &&
                    plantation.getDrive().getId() == driveId) {

                totalTrees++;

                for (SurvivalCheck check : checks) {

                    if (check.getPlantation() != null &&
                            check.getPlantation().getId()
                                    == plantation.getId() &&
                            "ALIVE".equalsIgnoreCase(check.getStatus())) {

                        aliveTrees++;

                        break;
                    }
                }
            }
        }


        if (totalTrees == 0) {
            return 0;
        }


        return (aliveTrees * 100.0) / totalTrees;
    }


    public double getSurvivalRateBySpecies(String species) {

        List<Plantation> plantations =
                plantationRepository.findAll();

        List<SurvivalCheck> checks =
                repository.findAll();

        int totalTrees = 0;
        int aliveTrees = 0;


        for (Plantation plantation : plantations) {

            if (plantation.getSpecies() != null &&
                    plantation.getSpecies()
                            .equalsIgnoreCase(species)) {

                totalTrees++;

                for (SurvivalCheck check : checks) {

                    if (check.getPlantation() != null &&
                            check.getPlantation().getId()
                                    == plantation.getId() &&
                            "ALIVE".equalsIgnoreCase(check.getStatus())) {

                        aliveTrees++;

                        break;
                    }
                }
            }
        }


        if (totalTrees == 0) {
            return 0;
        }


        return (aliveTrees * 100.0) / totalTrees;
    }
}