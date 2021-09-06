package com.reobotnet.consultas.jpa.repository.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reobotnet.consultas.jpa.repository.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
