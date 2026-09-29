package com.example.GreenLog.Service;

import com.example.GreenLog.Model.Volunteer;
import com.example.GreenLog.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VolunteerService {
    @Autowired
    VolunteerRepository repository;
    public List<Volunteer> getAllVolunteers() {
        return repository.findAll();

    }

    public String addVolunteer(Volunteer volunteer) {
        repository.save(volunteer);
        return "Volunteer added successfully";
    }

    public Volunteer getVolunteerById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String updateVolunteer(Volunteer volunteer) {
        repository.save(volunteer);
        return "Volunteer updated successfully";
    }

    public String deleteVolunteer(int id) {
        repository.deleteById(id);
        return "Volunteer deleted successfully";
    }

    public String deleteAllVolunteers() {
        repository.deleteAll();
        return "All volunteers deleted successfully";
    }
}
