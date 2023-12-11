package com.app.medical.model;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private ArrayList<MedicalServices> specialities ;
    private String  hopital ;
    private double rate;
    private String cin ;
    private String  phone ;
    private String  email;
}
