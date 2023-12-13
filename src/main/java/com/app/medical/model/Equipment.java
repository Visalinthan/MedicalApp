package com.app.medical.model;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipment {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
      private String name;
	  private String busy;
	  private String type ;

	@ManyToOne
	@JoinColumn(name = "medicalservices_id")
	private MedicalServices medicalServices;
	  
	  
}
