package com.app.medical.model;

import jakarta.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicalfile")
public class Appointement {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private ArrayList<Appointement>  appointement; 
	 private ArrayList<Medecin>  medecin ;  
	 private ArrayList<Patient>  patient ;
	 
}
