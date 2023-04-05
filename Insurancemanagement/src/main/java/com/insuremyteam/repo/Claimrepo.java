package com.insuremyteam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuremyteam.model.Claim;

public interface Claimrepo extends JpaRepository<Claim, Integer> {

}
