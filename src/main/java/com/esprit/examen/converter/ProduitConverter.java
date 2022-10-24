package com.esprit.examen.converter;

import org.modelmapper.ModelMapper;

import com.esprit.examen.dto.ProduitDTO;
import com.esprit.examen.entities.Produit;

public class ProduitConverter {

	public ProduitDTO convertEntityToDto(Produit produit) {
        ModelMapper modelMapper = new ModelMapper();
        ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);
        return produitDTO;
    }

    public Produit convertDtoToEntity(ProduitDTO produitDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Produit produit = modelMapper.map(produitDTO, Produit.class);
        return produit;
    }
    
    
}
