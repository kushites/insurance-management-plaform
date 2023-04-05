package com.insuremyteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuremyteam.model.Client;
import com.insuremyteam.service.Clientservice;

@RestController
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private Clientservice clientservice;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> findAllClient(){
		List<Client> list = clientservice.getAllClient();
		ResponseEntity<List<Client>> re = new ResponseEntity<List<Client>>(list, HttpStatus.ACCEPTED);
		return re;
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> findClient(@PathVariable Integer id){
		Client c = clientservice.getClientByid(id);
		ResponseEntity<Client> re = new ResponseEntity<Client>(c,HttpStatus.ACCEPTED);
		return re;
	}
	
	@PostMapping("/clients")
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		Client newclient = clientservice.saveClient(client);
		ResponseEntity<Client> re = new ResponseEntity<Client>(newclient, HttpStatus.CREATED);
		return re;
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> modifyClient(@RequestBody Client client, @PathVariable Integer id){
		Client  updatedclient = clientservice.updateClient(client, id);
		ResponseEntity<Client> re = new ResponseEntity<Client>(updatedclient, HttpStatus.ACCEPTED);
		return re;
	}
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Boolean> removeClient(@PathVariable Integer id){
		boolean value = clientservice.deleteClient(id);
		ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(value,HttpStatus.ACCEPTED);
		return re;
		
	}
}
