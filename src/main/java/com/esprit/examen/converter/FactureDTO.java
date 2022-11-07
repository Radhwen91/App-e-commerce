package com.esprit.examen.converter;



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
	private Long idFacturee;
	
	private float montantRemisee;
	
	private float montantFacturee;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateCreationFacturee;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModificationFacturee;
	
	
	private Boolean archiveee;


    
}
