/*
package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.converter.ProduitConverter;
import com.esprit.examen.dto.ProduitDTO;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
 class ProduitServiceImplTest {
	@Mock
	ProduitRepository produitRepository ;
	@InjectMocks
	IProduitService produitServic;
	@Autowired
	IProduitService produitService;
	@Autowired
	IStockService stockService;
	@Autowired
    ModelMapper modelMapper;
	@Autowired
	ProduitConverter produitConverter;
	
	Produit produit = new Produit(null, "ChocoTom", "biscuit", 0, new Date(), new Date(), null, null, null);
	
	List<Produit> produits = new ArrayList<Produit>() {
		{
		add(new Produit(null, "Oreo", "biscuit", 0, new Date(), new Date(), null, null, null));
		add(new Produit(null, "prince", "biscuit", 0, new Date(),  new Date(), null, null, null));
		}
	};
	
	@Test
	 void testAddProduit() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("30/09/2022");
		Produit p = new Produit(null, "ChocoTom1", "biscuit", 0, dateCreation, null, null, null, null);
		ProduitDTO produitDTO =produitConverter.convertEntityToDto(p);
		ProduitDTO produit = produitService.addProduit(produitDTO);
		System.out.print("Produit: "+produit);
		assertNotNull(produit.getIdProduit());
		assertTrue(produit.getCodeProduit().length() > 0);
		produitService.deleteProduit(produit.getIdProduit());
	}
	
	@Test
	 void testDeleteProduit() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("30/09/2022");
		Date dateDerniereModification = dateFormat.parse("1/10/2022");
		Produit p = new Produit(null, "Oreo", "biscuit", 0, dateCreation, dateDerniereModification, null, null, null);
		ProduitDTO produitDTO =produitConverter.convertEntityToDto(p);
		ProduitDTO produit = produitService.addProduit(produitDTO);
		produitService.deleteProduit(produit.getIdProduit());
		assertNull(produitService.retrieveProduit(produit.getIdProduit()));
	}
	
	@Test
	 void testRetrieveAllProduits() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("30/09/2022");
		Date dateDerniereModification = dateFormat.parse("1/10/2022");
		List<Produit> produits = produitService.retrieveAllProduits();
		int expected = produits.size();
		Produit p = new Produit(null, "Forree", "biscuit", 0, dateCreation, dateDerniereModification, null, null, null);
		ProduitDTO produitDTO =produitConverter.convertEntityToDto(p);
		ProduitDTO produit = produitService.addProduit(produitDTO);
		assertEquals(expected + 1, produitService.retrieveAllProduits().size());
		produitService.deleteProduit(produit.getIdProduit());
	}
	
	
	@Test
	 void testRetrieveAllProduitsMockito() throws ParseException {
		Mockito.when(produitRepository.findAll()).thenReturn(produits);
		List<Produit> ps = produitServic.retrieveAllProduits();
		Assertions.assertEquals(0,ps.size());
		verify(produitRepository).findAll();
	}
	
	@Test
	 void testRetrieveProduitsMockito() throws ParseException {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		ProduitDTO p = produitServic.retrieveProduit((long)1);
		assertNotNull(p);
		log.info("get==>"+ p.toString() );
		verify(produitRepository).findById(Mockito.anyLong());
	}
	
	@Test
	 void testUpdateProduit() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("30/09/2022");
		Date dateDerniereModification = dateFormat.parse("1/10/2022");
		Produit p = new Produit(null, "sablito", "biscuit", 0, dateCreation,null, null, null, null);
		ProduitDTO produitDTO =produitConverter.convertEntityToDto(p);
		ProduitDTO produit = produitService.addProduit(produitDTO);
		produit.setDateDerniereModification(dateDerniereModification);
		ProduitDTO ProduitUpdated = produitService.updateProduit(produit);
		assertNotNull(ProduitUpdated.getIdProduit());
		assertSame(dateDerniereModification, ProduitUpdated.getDateDerniereModification());
		produitService.deleteProduit(produit.getIdProduit());
	} 
	
	@Test
	 void testAssignProduitToStock() throws ParseException {
		System.out.print("///////////////////////////////////////// ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("30/09/2022");
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		Produit p = new Produit(null, "prince", "biscuit", 0, dateCreation, null, null, null, null);
		ProduitDTO produitDTO =produitConverter.convertEntityToDto(p);
		ProduitDTO produit = produitService.addProduit(produitDTO);
		System.out.print("Stock: "+savedStock);
		System.out.print("Produit: "+produit);
		produitService.assignProduitToStock(produit.getIdProduit(), savedStock.getIdStock());
		ProduitDTO p1 =produitService.retrieveProduit(produit.getIdProduit());
		assertNotNull(p1.getStock().getIdStock());
		System.out.print("///////////////////////////////////////// ");
		produitService.deleteProduit(produit.getIdProduit());
		stockService.deleteStock(savedStock.getIdStock());
		
	}
}
*/