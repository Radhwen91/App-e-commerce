package com.esprit.examen.services;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mockito.InjectMocks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.FactureDTO;
import com.esprit.examen.repositories.FactureRepository;

public class FacutreTestWithMock {
	
@InjectMocks
FactureServiceImpl factureService;

@Mock
FactureRepository factureRepository; 

	

@Test
public void getAllFacture() throws ParseException {
	
	
	List<Facture> listFacture = new ArrayList<Facture>();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date dateCreationFacture = dateFormat.parse("30/09/2000");
	
	listFacture.add(new Facture(23,21,dateCreationFacture,dateCreationFacture,true));
	listFacture.add(new Facture(30,44,dateCreationFacture,dateCreationFacture,true));
	
	when(factureService.retrieveAllFactures()).thenReturn(listFacture);

	//test
	List<Facture> empList = factureService.retrieveAllFactures();

	assertEquals(2, empList.size());
	verify(factureService, times(1)).retrieveAllFactures();
}
	
	
	
}
