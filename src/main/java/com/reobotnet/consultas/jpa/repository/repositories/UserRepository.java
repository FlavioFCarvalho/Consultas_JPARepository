package com.reobotnet.consultas.jpa.repository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reobotnet.consultas.jpa.repository.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	//http://localhost:8080/users/search-salary?minSalary=5000&maxSalary=10000&size=5
	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable);

	//http://localhost:8080/users/search-name?name=Maria
	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchName(String name, Pageable pageable);
	
    Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);
	
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
	

}
