package com.app.medical.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalFile {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @OneToMany(fetch=FetchType.EAGER, mappedBy = "medicalFile")
	 @Fetch(value = FetchMode.SUBSELECT)
	 private List<Medecin> medecin = new ArrayList<Medecin>() ;
	 @OneToMany(fetch=FetchType.EAGER, mappedBy = "medicalFile")
	 @Fetch(value = FetchMode.SUBSELECT)
	 private List<Patient> patient = new ArrayList<Patient>() ;
	 
}
