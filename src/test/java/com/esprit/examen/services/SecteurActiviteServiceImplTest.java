package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;

import lombok.extern.slf4j.Slf4j;



@ContextConfiguration(classes = {SecteurActiviteServiceImpl.class,FournisseurServiceImpl.class})
@ExtendWith(SpringExtension.class)
@Slf4j
public class SecteurActiviteServiceImplTest {

	@Autowired
	private SecteurActiviteServiceImpl secteuractiviteservice;
    @MockBean
    private SecteurActiviteRepository secteurActiviteRepository;
    

    @MockBean
    private FournisseurRepository fournisseurRepository;

	@Autowired
	private FournisseurServiceImpl fournisseurServiceImpl;


    @MockBean
    private ProduitRepository produitRepository;

    @MockBean
    private DetailFournisseurRepository detailFournisseurRepository;
    @Test
    void testRetrieveAllSecteurActivite() {
        ArrayList<SecteurActivite> secteurActiviteList = new ArrayList<>();
        when(this.secteurActiviteRepository.findAll()).thenReturn(secteurActiviteList);
        List<SecteurActivite> actualRetrieveAllSecteurActiviteResult = this.secteuractiviteservice.retrieveAllSecteurActivite();
        assertSame(secteurActiviteList, actualRetrieveAllSecteurActiviteResult);
        assertTrue(actualRetrieveAllSecteurActiviteResult.isEmpty());
        verify(this.secteurActiviteRepository).findAll();
    }
    
    @Test
    void testAddSecteurActivite() {
    	SecteurActivite secteurActivite = new SecteurActivite();
    	secteurActivite.setIdSecteurActivite(1L);
    	secteurActivite.setCodeSecteurActivite("Code");
    	secteurActivite.setLibelleSecteurActivite("libelle");;
    	secteurActivite.setFournisseurs(new HashSet<>());
    	


    	SecteurActivite secteurActivite2 = new SecteurActivite();
    	secteurActivite2.setIdSecteurActivite(1L);
    	secteurActivite2.setCodeSecteurActivite("Code2");
    	secteurActivite2.setLibelleSecteurActivite("libelle2");;
    	secteurActivite2.setFournisseurs(new HashSet<>());


        assertSame(secteurActivite2, this.secteuractiviteservice.addSecteurActivite(secteurActivite2));
        verify(this.secteurActiviteRepository).save((SecteurActivite) any());
    }
    @Test
    void testUpdateSecteurActivite() {
    	SecteurActivite secteurActivite = new SecteurActivite();
    	secteurActivite.setIdSecteurActivite(1L);
    	secteurActivite.setCodeSecteurActivite("Code");
    	secteurActivite.setLibelleSecteurActivite("libelle");;
    	secteurActivite.setFournisseurs(new HashSet<>());


    	SecteurActivite secteurActivite2 = new SecteurActivite();
    	secteurActivite2.setIdSecteurActivite(1L);
    	secteurActivite2.setCodeSecteurActivite("Code2");
    	secteurActivite2.setLibelleSecteurActivite("libelle2");;
    	secteurActivite2.setFournisseurs(new HashSet<>());



    	SecteurActivite actualUpdateSecteurActiviteResult = this.secteuractiviteservice.updateSecteurActivite(secteurActivite2);
        assertSame(secteurActivite2, actualUpdateSecteurActiviteResult);
        verify(this.secteurActiviteRepository).save((SecteurActivite) any());
 
    }
    @Test
    void testRetrieveSecteurActivite() {
    	SecteurActivite secteurActivite = new SecteurActivite();
    	secteurActivite.setIdSecteurActivite(1L);
    	secteurActivite.setCodeSecteurActivite("Code");
    	secteurActivite.setLibelleSecteurActivite("libelle");;
    	secteurActivite.setFournisseurs(new HashSet<>());


    	SecteurActivite secteurActivite2 = new SecteurActivite();
    	secteurActivite2.setIdSecteurActivite(1L);
    	secteurActivite2.setCodeSecteurActivite("Code2");
    	secteurActivite2.setLibelleSecteurActivite("libelle2");;
    	secteurActivite2.setFournisseurs(new HashSet<>());
        Optional<SecteurActivite> ofResult = Optional.of(secteurActivite2);
        when(this.secteurActiviteRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(secteurActivite2, this.secteuractiviteservice.retrieveSecteurActivite(123L));
        verify(this.secteurActiviteRepository).findById((Long) any());
    }
    
    @Test
    void testAssignSecteurActiviteToFournisseur() {
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setCodeSecteurActivite("Code Secteur Activite");
        secteurActivite.setFournisseurs(new HashSet<>());
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setLibelleSecteurActivite("Libelle Secteur Activite");
        Optional<SecteurActivite> ofResult = Optional.of(secteurActivite);
        when(this.secteurActiviteRepository.findById((Long) any())).thenReturn(ofResult);

        DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setAdresse("Adresse");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        detailFournisseur.setDateDebutCollaboration(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        detailFournisseur.setEmail("jane.doe@example.org");
        detailFournisseur.setFournisseur(new Fournisseur());
        detailFournisseur.setIdDetailFournisseur(1L);
        detailFournisseur.setMatricule("Matricule");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        fournisseur.setCode("Code");
        fournisseur.setDetailFournisseur(detailFournisseur);
        fournisseur.setFactures(new HashSet<>());
        fournisseur.setIdFournisseur(1L);
        fournisseur.setLibelle("Libelle");
        fournisseur.setSecteurActivites(new HashSet<>());

        DetailFournisseur detailFournisseur1 = new DetailFournisseur();
        detailFournisseur1.setAdresse("Adresse");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        detailFournisseur1.setDateDebutCollaboration(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        detailFournisseur1.setEmail("jane.doe@example.org");
        detailFournisseur1.setFournisseur(fournisseur);
        detailFournisseur1.setIdDetailFournisseur(1L);
        detailFournisseur1.setMatricule("Matricule");

        Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        fournisseur1.setCode("Code");
        fournisseur1.setDetailFournisseur(detailFournisseur1);
        fournisseur1.setFactures(new HashSet<>());
        fournisseur1.setIdFournisseur(1L);
        fournisseur1.setLibelle("Libelle");
        fournisseur1.setSecteurActivites(new HashSet<>());
        Optional<Fournisseur> ofResult1 = Optional.of(fournisseur1);

        Fournisseur fournisseur2 = new Fournisseur();
        fournisseur2.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        fournisseur2.setCode("Code");
        fournisseur2.setDetailFournisseur(new DetailFournisseur());
        fournisseur2.setFactures(new HashSet<>());
        fournisseur2.setIdFournisseur(1L);
        fournisseur2.setLibelle("Libelle");
        fournisseur2.setSecteurActivites(new HashSet<>());

        DetailFournisseur detailFournisseur2 = new DetailFournisseur();
        detailFournisseur2.setAdresse("Adresse");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        detailFournisseur2.setDateDebutCollaboration(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        detailFournisseur2.setEmail("jane.doe@example.org");
        detailFournisseur2.setFournisseur(fournisseur2);
        detailFournisseur2.setIdDetailFournisseur(1L);
        detailFournisseur2.setMatricule("Matricule");

        Fournisseur fournisseur3 = new Fournisseur();
        fournisseur3.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        fournisseur3.setCode("Code");
        fournisseur3.setDetailFournisseur(detailFournisseur2);
        fournisseur3.setFactures(new HashSet<>());
        fournisseur3.setIdFournisseur(1L);
        fournisseur3.setLibelle("Libelle");
        fournisseur3.setSecteurActivites(new HashSet<>());

        DetailFournisseur detailFournisseur3 = new DetailFournisseur();
        detailFournisseur3.setAdresse("Adresse");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        detailFournisseur3.setDateDebutCollaboration(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        detailFournisseur3.setEmail("jane.doe@example.org");
        detailFournisseur3.setFournisseur(fournisseur3);
        detailFournisseur3.setIdDetailFournisseur(1L);
        detailFournisseur3.setMatricule("Matricule");

        Fournisseur fournisseur4 = new Fournisseur();
        fournisseur4.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        fournisseur4.setCode("Code");
        fournisseur4.setDetailFournisseur(detailFournisseur3);
        fournisseur4.setFactures(new HashSet<>());
        fournisseur4.setIdFournisseur(1L);
        fournisseur4.setLibelle("Libelle");
        fournisseur4.setSecteurActivites(new HashSet<>());
        when(this.fournisseurRepository.save((Fournisseur) any())).thenReturn(fournisseur4);
        when(this.fournisseurRepository.findById((Long) any())).thenReturn(ofResult1);
        this.fournisseurServiceImpl.assignSecteurActiviteToFournisseur(1L, 1L);
        verify(this.secteurActiviteRepository).findById((Long) any());
        verify(this.fournisseurRepository).save((Fournisseur) any());
        verify(this.fournisseurRepository).findById((Long) any());
    }

}
