package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;



import com.esprit.examen.entities.Facture;

import com.esprit.examen.repositories.FactureRepository;

import lombok.extern.slf4j.Slf4j;




@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
 class FacutreTestWithMock {
	
@InjectMocks
FactureServiceImpl factureService;

@Mock
FactureRepository factureRepository; 

	

@Test
 void getAllFacture() throws ParseException {	
	List<Facture> listFacture = new ArrayList<Facture>();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date dateCreationFacture = dateFormat.parse("30/09/2000");	
	listFacture.add(new Facture(23,21,dateCreationFacture,dateCreationFacture,true));
	listFacture.add(new Facture(30,44,dateCreationFacture,dateCreationFacture,true));
	
	Mockito.when(factureService.retrieveAllFactures()).thenReturn(listFacture);
	List<Facture> empList = factureService.retrieveAllFactures();
	assertEquals(2, empList.size());
	verify(factureRepository, times(1)).findAll();
	 log.info("Add done ///////////////// ");
}
	
@SuppressWarnings("deprecation")
@Test
 void AddFacture() throws ParseException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date dateCreationFacture = dateFormat.parse("30/09/2000");
	Facture f =new Facture(23,21,dateCreationFacture,dateCreationFacture,true);
	MockitoAnnotations.initMocks(this);	
	factureService.addFacture(f);
    
    verify(factureRepository, times(1)).save(f);
    log.info("retrieve All done ///////////////// ");
}


@Test
	 void testDelete() throws ParseException {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date dateCreationFacture = dateFormat.parse("30/09/2000");
	Facture f =new Facture(23,21,dateCreationFacture,dateCreationFacture,true);

Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
if(factureService.retrieveFacture(1L) == null) {
	factureService.deleteFacture(f.getIdFacture());
	}
else
	factureService.deleteFacture((factureService.retrieveFacture(1L).getIdFacture()));
    verify(factureRepository, Mockito.times(1)).deleteById(f.getIdFacture());
      log.info("Delete done ///////////////// ");
    



}




}
