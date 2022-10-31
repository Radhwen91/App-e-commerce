package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Matchers.isA;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {
	
/*	  @Mock
	  StockRepository sr = Mockito.mock(StockRepository.class);
	  
	  @InjectMocks
	  IStockService ss = new StockServiceImpl();
	  
	    Stock stock1 = new Stock("stock1", 100, 1);
	    Stock stock2 = new Stock("stock2", 200, 2);
	    
	    List<Stock> listStocks = new ArrayList<Stock>() {
	        {
	            add(new Stock("Fruits", 80,10));
	            add(new Stock("Légumes", 90,20));
	        }
	    };
	   
	    @Test
	    public void addStockTest() {
	    	MockitoAnnotations.initMocks(this);
	    	stock2.setIdStock(23L);
	        ss.addStock(stock2);
	        verify(sr, times(1)).save(stock2);
	        System.out.println(stock2);
	        System.out.println(" Create is working correctly...!!");
	    }
	    
	    @Test
	    public void testRetrieveStockByid() {
	        when(sr.findById(Mockito.anyLong())).thenReturn(Optional.of(stock1));
	        Stock stockq = ss.retrieveStock(1L);

	        System.out.println(stockq);
	        Assertions.assertNotNull(stockq);
	    }
	    
	    @Test
	    public void testCreateNewObject() {
	        Stock obj = new Stock("new", 2,3);
	        when(sr.save(isA(Stock.class))).thenAnswer(invocation -> (Stock) invocation.getArguments()[0]);
	        Stock returnedObj = ss.addStock(obj);
	        ArgumentCaptor<Stock> savedObjectArgument = ArgumentCaptor.forClass(Stock.class);
	        verify(sr, times(1)).save(savedObjectArgument.capture());
	        verifyNoMoreInteractions(sr);

	        Stock savedRestObject = savedObjectArgument.getValue();
	        Assertions.assertNotNull(savedRestObject);
	        
	    }
	      @Test
	      public void testDeleteObject() {
	            Stock stock = new Stock();
	            stock.setLibelleStock("new test");
	            stock.setIdStock(1L);
	            when(sr.findById(stock.getIdStock())).thenReturn(Optional.of(stock));
	            Stock s = ss.retrieveStock(1L);
	            ss.deleteStock(s.getIdStock());
	            verify(sr).deleteById(s.getIdStock());
	            System.out.println("testDeleteObject works !");
	        }
	      
		    @Test
		    public void DeleteStockTest() {
		    	MockitoAnnotations.initMocks(this);
		        sr.save(stock1);
		        ss.deleteStock(stock1.getIdStock());
		        verify(sr, times(1)).deleteById(stock1.getIdStock());
		        System.out.println("Delete works !");

		    	}
	    
/*	    @Test
	    public void testRetrieveAllStocks() {
	    	MockitoAnnotations.initMocks(this);

	        List<Stock> stocks = new ArrayList();
	        stocks.add(new Stock());
	        when(sr.findAll()).thenReturn(stocks);
	        List<Stock> expected = ss.retrieveAllStocks();
	        Assertions.assertEquals(expected, stocks);
	        verify(sr).findAll();

	    }
	    
	    @Test
	    public void DeleteStockTest() {
	    	MockitoAnnotations.initMocks(this);
	        sr.save(stock1);
	        ss.deleteStock(stock1.getIdStock());
	        verify(sr, times(1)).deleteById(stock1.getIdStock());
	        System.out.println("Delete works !");

	    	}
	    
	    @Test
	    public void UpdateStockTest() {
	    	MockitoAnnotations.initMocks(this);
	        when(sr.save(stock1)).thenReturn(stock1);
	        assertNotNull(stock1);
	        assertEquals(stock1, ss.updateStock(stock1));
	        System.out.println("Update works !");
	    }

	    @Test
	    public void retrieveStockTest() {
	    	MockitoAnnotations.initMocks(this);
	        stock1.setIdStock(1L);
	        Mockito.when(sr.findById(1L)).thenReturn(Optional.of(stock1));
	        ss.retrieveStock(1L);
	        Assertions.assertNotNull(stock1);
	        System.out.println(stock1);
	        System.out.println(" Retrieve is working correctly...!!");
	    }*/

}
