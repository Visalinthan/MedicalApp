package com.app.medical.model;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn( name = "user_id" )
public class Medecin extends User{

    private double rate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialite_id")
    private Specialities specialities;

}
