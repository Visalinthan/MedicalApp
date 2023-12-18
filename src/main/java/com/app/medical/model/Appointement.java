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
	private String type ;
	private String description ;


	@JoinColumn(name = "medecin_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Medecin medecin;

	@JoinColumn(name = "patient_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medical_file_id")
	private MedicalFile medicalFile;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "salle_id")
	private Salle salle;


}
