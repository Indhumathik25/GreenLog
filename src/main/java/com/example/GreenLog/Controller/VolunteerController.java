package com.example.GreenLog.Controller;

import com.example.GreenLog.Model.Volunteer;
import com.example.GreenLog.Service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VolunteerController {
    @Autowired
    VolunteerService service;

    @GetMapping("Volunteer")
    public List<Volunteer> getAllVolunteers() {
        return service.getAllVolunteers();
    }
    @PostMapping("Volunteer")
    public String addVolunteer(@RequestBody Volunteer volunteer) {
        return service.addVolunteer(volunteer);
    }
    @GetMapping("Volunteer/{id}")
    public Volunteer getVolunteerById(@PathVariable int id) {
        return service.getVolunteerById(id);
    }
    @PutMapping("Volunteer")
    public String updateVolunteer(@RequestBody Volunteer volunteer) {
        return service.updateVolunteer(volunteer);
    }
    @DeleteMapping("Volunteer/{id}")
    public String deleteVolunteer(@PathVariable int id) {
        return service.deleteVolunteer(id);
    }
    @DeleteMapping("Volunteer/clear")
    public String deleteAllVolunteers() {
        return service.deleteAllVolunteers();
    }



}
