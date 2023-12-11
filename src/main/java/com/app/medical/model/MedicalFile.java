package com.app.medical.model;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalFile {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private ArrayList<Appointement> appointement;
	 private ArrayList<Medecin>  medecin ;  
	 private ArrayList<Patient>  patient ;
	 
}
