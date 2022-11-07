package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.converter.FactureDTO;
import com.esprit.examen.entities.Facture;

public interface IFactureService {
	List<Facture> retrieveAllFactures();

	List<Facture> getFacturesByFournisseur(Long idFournisseur);

	FactureDTO addFacture(FactureDTO f);

	void cancelFacture(Long id);

	Facture retrieveFacture(Long id);
	


}