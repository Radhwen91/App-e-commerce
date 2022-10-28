/*
package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import org.springframework.boot.test.context.SpringBootTest;


import com.esprit.examen.converter.ProduitConverter;
import com.esprit.examen.dto.ProduitDTO;
import com.esprit.examen.entities.Produit;

import com.esprit.examen.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
 class ProduitServiceImplMokitoTest {
	@Mock
	ProduitRepository produitRepository ;
	@InjectMocks
	ProduitServiceImpl produitService;
    ModelMapper modelMapper = new ModelMapper() ;
	ProduitConverter produitConverter =new  ProduitConverter();
	Produit produit = new Produit(null, "ChocoTom", "biscuit", 0, new Date(), new Date(), null, null, null);
	
	List<Produit> produits = new ArrayList<Produit>() {
		{
		add(new Produit(null, "Oreo", "biscuit", 0, new Date(), new Date(), null, null, null));
		add(new Produit(null, "prince", "biscuit", 0, new Date(),  new Date(), null, null, null));
		}
	};

	@Test
	 void testRetrieveAllProduitsMockito() throws ParseException {
		Mockito.when(produitRepository.findAll()).thenReturn(produits);
		List<Produit> ps = produitService.retrieveAllProduits();
		Assertions.assertEquals(2,ps.size());
		verify(produitRepository).findAll();
	}
	@Test
	 void testRetrieveProduitsMockito() throws ParseException {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		ProduitDTO p = produitService.retrieveProduit((long)1);
		assertNotNull(p);
		log.info("get===>"+ p.toString() );
		verify(produitRepository).findById(Mockito.anyLong());
	}
	
	
	
	
	
}*/