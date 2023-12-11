package com.app.medical.model;

import lombok.*;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private String firstName;
	 private String lastName;
	 private ArrayList<MedicalService> specialities ;
	 private String  hopital ;
	 private String  phone ;
	 private String  email;
	 private String  address;
	 private String gender; 
	 private String birthdate ;
	
	 
}
