package com.esprit.examen.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SecteurActiviteServiceImplTest {
	@Autowired
	SecteurActiviteServiceImpl secteuractiviteservice;
	@Test
	public SecteurActivite addSecteurActivite( ) {
		Set<Fournisseur> fa = (Set<Fournisseur>) new Fournisseur();
		SecteurActivite sa = new SecteurActivite(1000L,"aa","aa",fa);
		secteuractiviteservice.addSecteurActivite(sa);
		log.info("sa:"+sa);
		return sa;
	}

}
