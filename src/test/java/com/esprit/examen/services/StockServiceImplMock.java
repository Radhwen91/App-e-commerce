package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
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
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {
	
	
	  @Mock
	  StockRepository sr = Mockito.mock(StockRepository.class);
	  @InjectMocks
	  StockServiceImpl ss;
	  
	    Stock stock1 = new Stock("stock1", 100, 1);
	    Stock stock2 = new Stock("stock2", 200, 2);
	   
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
	    public void retrieveAllStocksTest() {
	    	MockitoAnnotations.initMocks(this);
	        Mockito.when(sr.findAll()).thenReturn(Stream
	                .of(stock1,stock2)
	                .collect(Collectors.toList()));
	        assertEquals(2,ss.retrieveAllStocks().size());
	        System.out.println("Retrieve operators works !");
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
	    }

}
