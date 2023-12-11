package com.app.medical.model;

import jakarta.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointement")
public class Appointement {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  private ArrayList<Patient>  paient ;
	  private ArrayList<MedicalServices> medicalservices ;
	  private LocalDate  date ;
	  private String hour ;
	  private String description ;
	  //private boolean  notification ;
	  private String typofillness ;
	  
	  
	  
}
