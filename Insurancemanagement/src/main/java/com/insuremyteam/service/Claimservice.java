package com.insuremyteam.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.insuremyteam.exceptions.NoClaimFound;

import com.insuremyteam.model.Claim;

@Component
public interface Claimservice {
	
public List<Claim> getAllClaim() throws NoClaimFound;
	
	public Claim getClaimByid(Integer id) throws NoClaimFound;
	
	public Claim saveClaim(Claim claim);
	
	public Claim updateClaim(Claim claim, Integer id) throws NoClaimFound;
	
	public boolean deleteClaim(Integer id) throws NoClaimFound;

}
