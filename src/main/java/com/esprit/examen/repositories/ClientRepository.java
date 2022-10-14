package com.esprit.examen.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.examen.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	//JPQL
		@Query ("SELECT  c FROM Client c WHERE c.dateNaissance between :d1 AND :d2")
		List<Client> retrieveClientsByDateNaissance(@Param("d1") Date fromDate,@Param("d2") Date toDate);

}
