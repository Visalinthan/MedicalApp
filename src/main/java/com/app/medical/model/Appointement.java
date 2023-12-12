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
	  
	  private ArrayList<Patient> paient ;
	  //private ArrayList<MedicalServices> medicalservices ;
	  private String date ;
	  private String hour ;
	  private String description ;
	  //private boolean  notification ;
	  private String typofillness ;
	  
	  
	  
}
