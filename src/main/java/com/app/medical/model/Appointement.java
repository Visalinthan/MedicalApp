package com.app.medical.model;

import javax.persistence.*;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String date ;
	private String hour ;
	private String typofillness ;
	private String description ;

	@JoinColumn(name = "medecin_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Medecin medecin;

	@JoinColumn(name = "patient_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;

	@JoinColumn(name = "service_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private MedicalServices medicalServices;


}
