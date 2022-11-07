package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.converter.FactureDTO;
import com.esprit.examen.entities.Facture;

public interface IFactureService {
	List<Facture> retrieveAllFactures();


	FactureDTO addFacture(FactureDTO f);


	Facture retrieveFacture(Long id);
	


}