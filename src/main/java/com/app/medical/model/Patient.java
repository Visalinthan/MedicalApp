package com.app.medical.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Data
//@NoArgsConstructor
@Getter
@Setter
@Entity
public class Patient extends User{


    //Relation Mappage



    public Patient() {

    }
    public Patient(Long id, String firstName, String lastName, String phone, String address, String gender, String birthdate, String role, String email, String password,
                   String cin) {
        super(id, firstName, lastName, phone, address, gender, birthdate, role, email, password, cin);
    }
}
