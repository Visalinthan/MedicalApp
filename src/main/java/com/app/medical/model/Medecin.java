package com.app.medical.model;

import jakarta.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medecin")
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private ArrayList<MedicalService> specialities ;
    private String  hopital ;
    private double rate;
    private String cin ;
    private String  phone ;
    private String  email;
}
