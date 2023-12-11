package com.app.medical.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalServices {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String name ;
	 private ArrayList<Equipment> equipments ;
	 private String  localisation;
	 private String  email ;
	 private String phone;
	 

}