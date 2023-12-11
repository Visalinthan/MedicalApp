package com.app.medical.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String firstName;
	 private String lastName;
	 private String hopital ;
	 private String phone ;
	 private String email;
	 private String address;
	 private String gender; 
	 private String birthdate ;
	 private String mdp;
}
