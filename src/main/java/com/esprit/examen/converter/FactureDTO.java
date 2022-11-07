package com.esprit.examen.converter;



import java.util.Date;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Reglement;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private float montantRemise;
	
	private float montantFacture;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateCreationFacture;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateDerniereModificationFacture;
	
	
	private Boolean archiveee;
    @OneToMany(mappedBy="facture")
    @JsonIgnore
    private Set<Reglement> reglements;

    @ManyToOne
    @JsonIgnore
    private Fournisseur fournisseur;
    
	@OneToMany(mappedBy = "facture")
	@JsonIgnore
	private Set<DetailFacture> detailsFacture;
	
	
		

    
}
