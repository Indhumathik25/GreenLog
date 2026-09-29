package com.example.GreenLog.Repository;

import com.example.GreenLog.Model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {
}
