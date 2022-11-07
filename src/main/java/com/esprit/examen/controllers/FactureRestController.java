package com.esprit.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esprit.examen.converter.FactureDTO;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.services.IFactureService;

import io.swagger.annotations.Api;


@RestController
@Api(tags = "Gestion des factures")
@RequestMapping("/facture")
@CrossOrigin("*")
public class FactureRestController {

    @Autowired
    IFactureService factureService;

 
    @GetMapping("/retrieve-all-factures")
    @ResponseBody
    public List<Facture> getFactures() {
    	 return factureService.retrieveAllFactures();
      
    }

   
    @GetMapping("/retrieve-facture/{facture-id}")
    @ResponseBody
    public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
        return factureService.retrieveFacture(factureId);
    }

   
    @PostMapping("/add-facture")
    @ResponseBody
    public FactureDTO addFacture(@RequestBody FactureDTO f) {
         return  factureService.addFacture(f);
         
    }


    @PutMapping("/cancel-facture/{facture-id}")
    @ResponseBody
    public void cancelFacture(@PathVariable("facture-id") Long factureId) {
        factureService.cancelFacture(factureId);
    }

    
    @GetMapping("/getFactureByFournisseur/{fournisseur-id}")
    @ResponseBody
    public List<Facture> getFactureByFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        return factureService.getFacturesByFournisseur(fournisseurId);
    }


   

  

}