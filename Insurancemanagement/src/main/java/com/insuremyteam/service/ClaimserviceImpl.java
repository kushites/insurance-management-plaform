package com.insuremyteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuremyteam.exceptions.NoClaimFound;
import com.insuremyteam.model.Claim;
import com.insuremyteam.repo.Claimrepo;

@Service
public class ClaimserviceImpl implements Claimservice{
	@Autowired
	private Claimrepo claimrepo;

	@Override
	public List<Claim> getAllClaim() throws NoClaimFound {
		List<Claim>  list= claimrepo.findAll();
		
		if(list==null) {
			throw new NoClaimFound("There is no claim");
		}
		return list;
	}

	@Override
	public Claim getClaimByid(Integer id) throws NoClaimFound {
		Optional<Claim> opt = claimrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoClaimFound("No Claim Found with this id "+ id);
		}
		return opt.get();
	}

	@Override
	public Claim saveClaim(Claim claim) {
		
		return claimrepo.save(claim);
	}

	@Override
	public Claim updateClaim(Claim claim, Integer id) throws NoClaimFound {
		Optional<Claim> opt = claimrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoClaimFound("No Claim Found with this id:"+ id );
		}
		Claim c = new Claim(id,claim.getNumber(),claim.getDescription(),claim.getClaimdate(),claim.isClaimstatus());
		
		return claimrepo.save(c);
	}

	@Override
	public boolean deleteClaim(Integer id) throws NoClaimFound {
		
		Optional<Claim> opt = claimrepo.findById(id);
		if(opt.isEmpty()) {
			throw new NoClaimFound("No claim Found with this id:"+id);
		}
		claimrepo.delete(opt.get());
		return true;
	}

}
