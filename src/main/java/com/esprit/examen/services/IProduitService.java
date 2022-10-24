package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.dto.ProduitDTO;
import com.esprit.examen.entities.Produit;

public interface IProduitService {

	List<Produit> retrieveAllProduits();

	ProduitDTO addProduit(ProduitDTO p);

	void deleteProduit(Long id);

	ProduitDTO updateProduit(ProduitDTO p);

	ProduitDTO retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);



}
