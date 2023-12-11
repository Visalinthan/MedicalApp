package com.app.medical.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medecin")
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
}
