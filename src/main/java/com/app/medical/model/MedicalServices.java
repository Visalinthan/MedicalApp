package com.app.medical.model;

import lombok.*;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicalservices")
public class MedicalServices {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String name ;
	 private ArrayList<Equipment>  equipments ;
	 private String  localisation;
	 private String  email ;
	 private String phone;
	 

}
