package com.esprit.examen.entities;



import java.util.Date;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FactureDTO {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	
	private float montantRemise;
	
	private float montantFacture;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateCreationFacture;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModificationFacture;
	
	
	private Boolean archivee;


    
}
