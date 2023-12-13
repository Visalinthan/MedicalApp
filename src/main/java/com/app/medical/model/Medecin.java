package com.app.medical.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "medecin")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<MedicalServices> specialities = new ArrayList<MedicalServices>() ;
    private String  hopital ;
    private double rate;
    private String cin ;
    private String  phone ;
    private String  email;

    @ManyToOne
    @JoinColumn(name = "medicalFile_id")
    private MedicalFile medicalFile;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "medecin")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Appointement> appointements = new ArrayList<Appointement>();

}
