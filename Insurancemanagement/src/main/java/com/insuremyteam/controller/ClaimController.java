package com.insuremyteam.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.insuremyteam.model.Claim;
import com.insuremyteam.service.Claimservice;

@RestController
@RequestMapping("/api")
public class ClaimController {
	
	@Autowired
	private Claimservice claimservice;
	
	@GetMapping("/claims")
	public ResponseEntity<List<Claim>> findAllClaims(){
		List<Claim> list = claimservice.getAllClaim();
		ResponseEntity<List<Claim>> re = new ResponseEntity<List<Claim>>(list, HttpStatus.ACCEPTED);
		return re;
	}
	
	@GetMapping("/claims/{id}")
	public ResponseEntity<Claim> findClaim(@PathVariable Integer id){
		Claim claim = claimservice.getClaimByid(id);
		ResponseEntity<Claim> re = new ResponseEntity<Claim>(claim, HttpStatus.ACCEPTED);
		return re;
	}
	
	@PostMapping("/claims")
	public ResponseEntity<Claim> createClaim(@RequestBody Claim claim){
		Claim newclaim = claimservice.saveClaim(claim);
		ResponseEntity<Claim> re = new ResponseEntity<Claim>(newclaim, HttpStatus.CREATED);
		return re;
	}
	
	@PutMapping("/claims/{id}")
	public ResponseEntity<Claim> alterClaim(@RequestBody Claim claim, @PathVariable Integer id){
		Claim updatedclaim = claimservice.updateClaim(claim, id);
		ResponseEntity<Claim> re = new ResponseEntity<Claim>(updatedclaim, HttpStatus.ACCEPTED);
		return re;
	}
	
	@DeleteMapping("/claims/{id}")
	public ResponseEntity<Boolean> removeClaim(@PathVariable Integer id){
		boolean value = claimservice.deleteClaim(id);
		ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(value, HttpStatus.ACCEPTED);
		return re;
	}
}
