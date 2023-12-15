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

}
