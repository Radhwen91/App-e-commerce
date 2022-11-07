package com.esprit.examen.converter;


import org.modelmapper.ModelMapper;


import com.esprit.examen.entities.Facture;


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
