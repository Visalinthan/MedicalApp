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
    private String  phone;

    private String address;
    private String gender;
    private String birthdate;

    private String cin;

    @Column(unique=true)
    private String  email;
    private String password;
    private String role;

    private ArrayList<MedicalServices> specialities ;
}
