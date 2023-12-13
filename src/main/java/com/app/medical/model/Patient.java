package com.app.medical.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Patient extends User{
    public Patient(Long id, String firstName, String lastName, String phone, String address, String gender, String birthdate, String role, String email, String password) {
        super(id, firstName, lastName, phone, address, gender, birthdate, role, email, password);
    }
}
