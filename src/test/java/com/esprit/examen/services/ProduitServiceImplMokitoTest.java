
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
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;



import com.esprit.examen.converter.ProduitConverter;
import com.esprit.examen.dto.ProduitDTO;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;

import lombok.extern.slf4j.Slf4j;
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

@Slf4j
 class ProduitServiceImplMokitoTest {
	@Autowired
	IStockService stockService;
	@Mock
	ProduitRepository produitRepository ;
	@Mock
	StockRepository  stockrepository ;
	@InjectMocks
	ProduitServiceImpl produitService;
    ModelMapper modelMapper = new ModelMapper() ;
	ProduitConverter produitConverter =new  ProduitConverter();
	Produit produit = new Produit(null, "ChocoTom", "biscuit", 0, new Date(), new Date(), null, null, null);
	Stock s = new Stock("stock test",10,100);
	List<Produit> produits = new ArrayList<Produit>() {
		{
		add(new Produit(null, "Oreo", "biscuit", 0, new Date(), new Date(), null, null, null));
		add(new Produit(null, "prince", "biscuit", 0, new Date(),  new Date(), null, null, null));
		}
	};
@Order(1)
	@Test
	void testAddProduitMokito() throws ParseException{
		ProduitDTO produitDTO =produitConverter.convertEntityToDto(produit);
        ProduitDTO produitAdded = produitService.addProduit(produitDTO);
        verify(produitRepository, Mockito.times(1)).save(Mockito.isA(Produit.class));
        Mockito.verifyNoMoreInteractions(produitRepository);
        Assertions.assertNotNull(produitAdded);
        log.info("produit:"+produitAdded.getIdProduit()+"/"+produitAdded.getCodeProduit()+"/" + produitAdded.getLibelleProduit() +"/"+ produitAdded.getDateCreation() +"/"+ produitAdded.getDateDerniereModification());
        log.info("++++++++++++++++++++++testAddProduitMokito is works+++++++++++++++++++++ ");
	}
	@Order(5)
	@Test
	 void testRetrieveAllProduitsMockito() throws ParseException {
		Mockito.when(produitRepository.findAll()).thenReturn(produits);
		List<Produit> ps = produitService.retrieveAllProduits();
		log.info(ps.toString());
		Assertions.assertEquals(2,ps.size());
		verify(produitRepository).findAll();
		log.info("+++++++++++++testRetrieveAllProduitsMockito is works++++++++++++++++");
	}
	@Order(3)
	@Test
	 void testRetrieveProduitsMockito() throws ParseException {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		ProduitDTO p = produitService.retrieveProduit((long)1);
		assertNotNull(p);
		log.info("get===>"+ p.toString() );
		log.info("get===>detail  "+ p.getLibelleProduit()+"/" + p.getDateCreation() + "/"+ p.getDateDerniereModification() );
		verify(produitRepository).findById(Mockito.anyLong());
		log.info("+++++++++++testRetrieveProduitsMockito is works ++++++++++++");
	}
	
	@Order(2)
	 @Test
	    public void UpdateStockTest() throws ParseException {
		 	Mockito.when(produitRepository.save(Mockito.isA(Produit.class))).thenReturn(produit);
		 	assertNotNull(produit);
		 	log.info("produit:"+produit.getIdProduit()+"/"+produit.getCodeProduit()+"/" + produit.getLibelleProduit() +"/"+ produit.getDateCreation() +"/"+ produit.getDateDerniereModification());
		 	ProduitDTO produitDTO =produitConverter.convertEntityToDto(produit);
		 	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	Date dateDerniereModification = dateFormat.parse("1/10/2022");
		 	produit.setDateDerniereModification(dateDerniereModification);
		 	ProduitDTO ProduitUpdated = produitService.updateProduit(produitDTO);
		 	assertFalse("Dates are the same!", (ProduitUpdated.getDateDerniereModification().getTime() - produit.getDateDerniereModification().getTime()) == 0);
		 	assertTrue("ProduitUpdated should be greater than produit!", (ProduitUpdated.getDateDerniereModification().getTime() > produit.getDateDerniereModification().getTime()) );
	        assertEquals(ProduitUpdated.getIdProduit(), produit.getIdProduit());
	        System.out.println("+++++++++++++++++UpdateStockTest works !++++++++++++++++++++");
	    }
	
	@Order(4)
	@Test
   		public void testDeleteProduitMokito() {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		if(produitService.retrieveProduit(1L) == null) {
		produitService.deleteProduit(produit.getIdProduit());
		}else
			produitService.deleteProduit((produitService.retrieveProduit(1L).getIdProduit()));
        verify(produitRepository, Mockito.times(1)).deleteById(produit.getIdProduit());
          log.info("+++++++++++++++++++++++++testDeleteProduitMokito is works++++++++++++++++++++++++ ");
      }
	/*@Order(3)
	@Test
	 void testAssignProduitToStock() throws ParseException {
		Mockito.when(produitRepository.save(Mockito.isA(Produit.class))).thenReturn(produit);
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		Mockito.when(stockrepository.save(Mockito.isA(Stock.class))).thenReturn(s);
		Mockito.when(stockrepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
		Produit savedProduit = produitRepository.save(produit);
		Stock savedStock= stockrepository.save(s);
		System.out.print("Stock: ------------"+savedStock.getIdStock()+"---------");
		System.out.print("Produit: -----------"+savedProduit.getIdProduit()+"---------");
		produitService.assignProduitToStock(savedProduit.getIdProduit(), savedStock.getIdStock());
		ProduitDTO produitAssigned =produitService.retrieveProduit(savedProduit.getIdProduit());
		assertNotNull(produitAssigned.getStock().getIdStock());
        verify(produitRepository, Mockito.times(1)).save(produit);
        verify(stockrepository, Mockito.times(1)).save(s);
		log.info("+++++++++++++++++++++++++testAssignProduitToStock is works++++++++++++++++++++++++ ");
	}*/
	
	
	
}