package com.example.GreenLog.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PlantationDrive {
    @Id
    private int id;


    private String name;

    private String date;

    private String location;

}
