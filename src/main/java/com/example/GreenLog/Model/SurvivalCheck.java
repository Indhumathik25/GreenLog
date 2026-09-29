package com.example.GreenLog.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SurvivalCheck {
    @Id
    private int id;

    private String checkDate;

    private String status;
    @ManyToOne
    private Plantation plantation;

    @ManyToOne
    private Volunteer volunteer;
}
