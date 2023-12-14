package com.app.medical.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Data
//@NoArgsConstructor
@Entity
public class Medecin extends User{

    private double rate;


    /*@ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)*/

    //@JoinColumn(name = "medicalservice_id")
    //pour éviter conflit de Suppression dans table jointure
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(fetch = FetchType.LAZY)
    private List<MedicalServices> medicalServices = new ArrayList<MedicalServices>();;


    /*@OneToMany(mappedBy="medecin", fetch=FetchType.LAZY, cascade = CascadeType.ALL)*/
    //private List<Appointement> appointements = new ArrayList<Appointement>();*/



    public Medecin()  {

    }

    public Medecin(Long id, String firstName, String lastName, String phone, String address, String gender, String birthdate, String role, String email, String password, String cin, double rate) {
        super(id, firstName, lastName, phone, address, gender, birthdate, role, email, password, cin);
        this.rate = rate;
    }
}
