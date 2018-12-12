package com.pronix.cabforall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pronix.cabforall.model.Validation;
@Repository
public interface ValidationRepo extends JpaRepository<Validation, String>{
	
}
