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

	//private List<Consultation> consultations = new ArrayList<Consultation>();

	@JoinColumn(name = "medecin_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Medecin medecin;

	@JoinColumn(name = "patient_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Patient patient;

	@JoinColumn(name = "consultation_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Consultation consultation;

	@JoinColumn(name = "presciption_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private  Prescription presciption;


}
