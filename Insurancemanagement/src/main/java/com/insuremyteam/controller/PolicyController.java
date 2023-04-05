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

import com.insuremyteam.model.Policy;
import com.insuremyteam.service.Policyservice;

@RestController
@RequestMapping("/api")
public class PolicyController {
	@Autowired
	private Policyservice policyservice;
	
	@GetMapping("/policies")
	public ResponseEntity<List<Policy>> findAllPolicy(){
		List<Policy> list = policyservice.getAllPolicy();
		ResponseEntity<List<Policy>> re = new ResponseEntity<List<Policy>>(list,HttpStatus.ACCEPTED);
		return re;
	}
	
	@GetMapping("/policies/{id}")
	public ResponseEntity<Policy> findPolicy(@PathVariable Integer id){
		Policy p = policyservice.getPolicyByid(id);
		ResponseEntity<Policy> re = new ResponseEntity<Policy>(p, HttpStatus.ACCEPTED);
		return re;
	}
	
	@PostMapping("/policies")
	public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy){
		Policy newpolicy = policyservice.savePolicy(policy);
		ResponseEntity<Policy> re = new ResponseEntity<Policy>(newpolicy, HttpStatus.CREATED);
		
		return re;
	}
	
	@PutMapping("/policies/{id}")
	public ResponseEntity<Policy> alterPolicy(@RequestBody Policy policy, @PathVariable Integer id){
		Policy updatedpolicy = policyservice.updatePolicy(policy, id);
		ResponseEntity<Policy> re = new ResponseEntity<Policy>(updatedpolicy, HttpStatus.ACCEPTED);
		return re;
	}
	
	@DeleteMapping("/policies/{id}")
	public ResponseEntity<Boolean> deletePolicy(@PathVariable Integer id){
		boolean value = policyservice.deletePolicy(id);
		ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(value,HttpStatus.ACCEPTED);
		return re;
	}
	
}
