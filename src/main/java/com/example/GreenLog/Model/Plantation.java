package com.example.GreenLog.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Plantation {
    @Id
    private int id;

    private String species;

    private String location;

    private String datePlanted;

    private String nextCheckInDate;

    @ManyToOne
    private PlantationDrive drive;

    @ManyToOne
    private Volunteer volunteer;

}
