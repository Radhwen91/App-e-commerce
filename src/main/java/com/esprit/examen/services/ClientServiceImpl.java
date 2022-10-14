package com.esprit.examen.services;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Client;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements IClientService {
	@Autowired
	ClientRepository clientRepository;


	@Override
	public List<Client> retrieveAllClients() {
		// récuperer la date à l'instant t1
		log.info("In method retrieveAllClients");
		List<Client> clients = (List<Client>) clientRepository.findAll();
		for (Client client : clients) {
			log.info(" client : " + client);
		}
		log.info("out of method retrieveAllClients");
		// récuperer la date à l'instant t2
		// temps execution = t2 - t1
		return clients;
	}
		

	@Override
	public Client addClient(Client c) {
		log.info("In method addClient");
		clientRepository.save(c);
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		log.info("In method deleteClient");
		clientRepository.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client c) {
		log.info("In method updateClient");
		clientRepository.save(c);
		return c;
	}

	@Override
	public Client retrieveClient(Long id) {
		log.info("In method retrieveClient");
		clientRepository.findById(id);
		Client s=clientRepository.findById(id).get();
		return s;
	}

	
	@Override
	public List<Client> getClientByDateNaissance(Date d1, Date d2) {
		log.info("In method getClientByDateNaissance");
		return clientRepository.retrieveClientsByDateNaissance(d1, d2);
	}
	

}
