package com.app.medical.model;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medecin extends User{
    private String cin;
    private double rate;
    private String specialite;

   /* @ManyToMany(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<MedicalServices> MedicalServices = new ArrayList<>() ;*/


}
