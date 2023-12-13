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



}
