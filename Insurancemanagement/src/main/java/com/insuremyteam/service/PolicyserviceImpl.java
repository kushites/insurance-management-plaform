package com.insuremyteam.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.exceptions.NoPolicyFound;
import com.insuremyteam.model.Policy;
import com.insuremyteam.repo.Policyrepo;

@Service
public class PolicyserviceImpl implements Policyservice {
	
	@Autowired
	private Policyrepo policyrepo;

	@Override
	public List<Policy> getAllPolicy() throws NoPolicyFound {
		List<Policy> list = policyrepo.findAll();
		if(list == null) {
			throw new NoPolicyFound("There is no policy");
		}
		
		return list;
	}

	@Override
	public Policy getPolicyByid(Integer id) throws NoPolicyFound {
		Optional<Policy> opt = policyrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoPolicyFound("No Policy Found with this id:"+id);
		}
		return opt.get();
	}

	@Override
	public Policy savePolicy(Policy policy) {
		
		return policyrepo.save(policy);
	}

	@Override
	public Policy updatePolicy(Policy policy, Integer id) throws NoPolicyFound {
		Optional<Policy> opt = policyrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoPolicyFound("No Policy Found with this id:"+id);
		}
		opt.get().setNumber(policy.getNumber());
		opt.get().setType(policy.getType());
		opt.get().setPremium(policy.getPremium());
		opt.get().setStartdate(policy.getStartdate());
		opt.get().setEnddate(policy.getEnddate());
		return policyrepo.save(opt.get()) ;
	}

	@Override
	public boolean deletePolicy(Integer id) throws NoPolicyFound {
		Optional<Policy> opt = policyrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoPolicyFound("No Policy Found with this id:"+id);
		}
		policyrepo.delete(opt.get());
		return true;
	}
	
	

}
