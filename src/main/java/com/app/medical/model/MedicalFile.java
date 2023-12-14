package com.app.medical.model;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "patient_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Patient patient;


	private ArrayList<Appointement> appointmentList;
	private ArrayList<Consultation> consultationList;
	private HashMap<String,String> statistiques;




}
