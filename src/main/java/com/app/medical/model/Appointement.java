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









}
