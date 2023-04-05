package com.insuremyteam.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.insuremyteam.exceptions.NoClientFound;
import com.insuremyteam.model.Client;

@Component
public interface Clientservice {
	public List<Client> getAllClient() throws NoClientFound;
	
	public Client getClientByid(Integer id) throws NoClientFound;
	
	public Client saveClient(Client client);
	
	public Client updateClient(Client client, Integer id) throws NoClientFound;
	
	public boolean deleteClient(Integer id) throws NoClientFound;
}
