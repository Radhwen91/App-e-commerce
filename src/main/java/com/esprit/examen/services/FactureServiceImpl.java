package com.esprit.examen.services;

import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.converter.FactureConverter;
import com.esprit.examen.converter.FactureDTO;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

	@Autowired
	FactureRepository factureRepository;
	@Autowired
	OperateurRepository operateurRepository;
	@Autowired
	DetailFactureRepository detailFactureRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	ProduitRepository produitRepository;
    @Autowired
    ReglementServiceImpl reglementService;
   
   
    FactureConverter factureConverter = new FactureConverter();
   
    ModelMapper modelMapper = new ModelMapper();
    
    
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = factureRepository.findAll();
		for (Facture facture : factures) {
			log.info(" facture : " + facture);
		}
		return factures;
	}

	
	public FactureDTO addFacture(FactureDTO f) {
		
		
		Facture facture = factureConverter.convertDtoToEntity(f);
		
		factureRepository.save(facture);
		
		return factureConverter.convertEntityToDto(facture);
		
	}
	




	@Override
	public Facture retrieveFacture(Long factureId) {

		Facture facture = factureRepository.findById(factureId).orElse(null);
		log.info("facture :" + facture);
		return facture;
	}




	
	public void deleteFacture(Long factureId) {
		
			factureRepository.deleteById(factureId);
		
		
		
	}








	
	

}