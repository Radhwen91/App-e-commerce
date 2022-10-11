package com.esprit.examen;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.services.IStockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;
	
	@Test
	public void testAddStock() {
	List<Stock> stocks = stockService.retrieveAllStocks();
	int expected = stocks.size();
	List<Stock> finalList =new ArrayList<>();
	finalList.addAll(stocks);
	int finalListSize=finalList.size() ;
	Stock s = new Stock();
	s.setLibelleStock("stock test");
	s.setQte(10);
	s.setQteMin(100);
	Stock savedStock= stockService.addStock(s);
	assertEquals(expected+1,finalListSize + 1 );
	assertNotNull(savedStock.getLibelleStock());
	stockService.deleteStock(savedStock.getIdStock());
	}
		
	
	/*@Test
	public void testAddStockOptimized() {

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
	*/

}