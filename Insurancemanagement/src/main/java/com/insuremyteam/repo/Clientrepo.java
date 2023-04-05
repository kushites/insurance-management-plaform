package com.insuremyteam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuremyteam.model.Client;

public interface Clientrepo extends JpaRepository<Client, Integer>{

}
