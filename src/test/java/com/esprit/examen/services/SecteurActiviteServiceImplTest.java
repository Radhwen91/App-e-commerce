package com.esprit.examen.services;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.SecteurActivite;

import lombok.extern.slf4j.Slf4j;



@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SecteurActiviteServiceImplTest {
	@Autowired
	SecteurActiviteServiceImpl secteuractiviteservice;
	@Test
	public void addSecteurActivite( ) {
		SecteurActivite sa = new SecteurActivite(1000L,"aa","aa");
		SecteurActivite s = secteuractiviteservice.addSecteurActivite(sa);
		log.info("s///////////////////////////////////////////////////////////////a:"+s);
	

	}

}
