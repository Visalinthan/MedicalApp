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
public class MedicalServices {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String name ;
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "medicalServices")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Equipment> equipments = new ArrayList<Equipment>() ;
	 private String  localisation;
	 private String  email ;
	 private String phone;

	@ManyToOne
	@JoinColumn(name = "medecin_id")
	private Medecin medecin;
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "medicalServices")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Appointement> appointements = new ArrayList<Appointement>();

	 

}