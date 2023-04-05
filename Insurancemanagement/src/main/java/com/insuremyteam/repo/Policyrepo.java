package com.insuremyteam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuremyteam.model.Policy;

public interface Policyrepo extends JpaRepository<Policy, Integer> {

}
