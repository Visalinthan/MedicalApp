package com.app.medical.model;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointement {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;


	 @ManyToOne
	 @JoinColumn(name = "patient_id")
	 private Patient patient;
	 //private ArrayList<Patient> paient ;
	 //private ArrayList<MedicalServices> medicalservices ;
	 @ManyToOne
	 @JoinColumn(name = "medecin_id")
	 private Medecin medecin;

	@ManyToOne
	@JoinColumn(name = "medicalservices_id")
	private MedicalServices medicalServices;


	 /*@ManyToOne
	 @JoinColumn(name = "medicalFile_id")
	 private MedicalFile medicalFile;*/
	  private String date ;
	  private String hour ;
	  private String description ;
	  //private boolean  notification ;
	  private String typofillness ;


	  
	  
	  
}
