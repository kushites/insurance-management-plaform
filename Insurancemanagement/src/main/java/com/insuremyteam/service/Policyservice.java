package com.insuremyteam.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.insuremyteam.exceptions.NoPolicyFound;
import com.insuremyteam.model.Policy;


@Component
public interface Policyservice {
	
	public List<Policy> getAllPolicy() throws NoPolicyFound;
	
	public Policy getPolicyByid(Integer id) throws NoPolicyFound;
	
	
	public Policy savePolicy(Policy policy);
	
	public Policy updatePolicy(Policy policy, Integer id) throws NoPolicyFound;
	
	public boolean deletePolicy(Integer id) throws NoPolicyFound;
}
