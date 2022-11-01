package com.esprit.examen.converter;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.FactureDTO;

@Component
public class FactureConverter {
	  public FactureDTO convertEntityToDto(Facture facutre) {
	        ModelMapper modelMapper = new ModelMapper();
	        return modelMapper.map(facutre, FactureDTO.class);
	        
	    }

	    public Facture convertDtoToEntity(FactureDTO factureDTO) {
	        ModelMapper modelMapper = new ModelMapper();
	        return modelMapper.map(factureDTO, Facture.class);
	       
	    }
}
