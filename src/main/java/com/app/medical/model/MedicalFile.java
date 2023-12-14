package com.app.medical.model;

import javax.persistence.*;

import lombok.*;


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



}
