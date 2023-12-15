package com.app.medical.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Data
//@NoArgsConstructor
@Getter
@Setter
@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String dateOfPrescription;
    private String description;
    private String medicationList;




    public Prescription() {

    }

}
