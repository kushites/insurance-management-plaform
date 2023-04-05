package com.insuremyteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.exceptions.NoClientFound;
import com.insuremyteam.model.Client;
import com.insuremyteam.repo.Clientrepo;
import com.insuremyteam.repo.Policyrepo;

@Service
public class ClientserviceImpl implements Clientservice {
	
	@Autowired
	private Clientrepo clientrepo;
	
	@Autowired
	private Policyrepo policyrepo;
	@Override
	public List<Client> getAllClient() throws NoClientFound {
		List<Client> list = clientrepo.findAll();
		if(list==null) {
			throw new NoClientFound("There is no client");
		}
		return list;
	}

	@Override
	public Client getClientByid(Integer id) throws NoClientFound {
		Optional<Client> opt = clientrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoClientFound("No client Found with this id:"+id);
		}
		return opt.get();
	}

	@Override
	public Client saveClient(Client client) {
		
		return clientrepo.save(client);
	}

	@Override
	public Client updateClient(Client client, Integer id) throws NoClientFound {
		Optional<Client> opt = clientrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoClientFound("No Client Found with this id:"+id);
		}
		opt.get().setAddress(client.getAddress());
		opt.get().setContact(client.getContact());
		opt.get().setDateofbirth(client.getDateofbirth());
		opt.get().setName(client.getName());
		
		
		return clientrepo.save(opt.get());
		
	}

	@Override
	public boolean deleteClient(Integer id) throws NoClientFound {
		Optional<Client> opt = clientrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoClientFound("No Client Found with this id:"+id);
		}
		clientrepo.delete(opt.get());
		return true;
	}

}
