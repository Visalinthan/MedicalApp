package com.app.medical.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Medecin extends User{
    private String cin;
    private double rate;


    @ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<MedicalServices> specialities = new ArrayList<>() ;

    @Builder
    public Medecin(Long id, String firstName, String lastName, String phone, String address, String gender, String birthdate, String role, String email, String password, String cin, double rate) {
        super(id, firstName, lastName, phone, address, gender, birthdate, role, email, password);
        this.cin = cin;
        this.rate = rate;
    }

}
