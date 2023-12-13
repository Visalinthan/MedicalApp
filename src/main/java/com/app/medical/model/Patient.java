package com.app.medical.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "patient")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Appointement> appointements = new ArrayList<Appointement>();

	@ManyToOne
	@JoinColumn(name = "medicalFile_id")
	private MedicalFile medicalFile;
}
