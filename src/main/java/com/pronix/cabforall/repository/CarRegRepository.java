package com.pronix.cabforall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pronix.cabforall.model.CarRegistration;
@Repository
public interface CarRegRepository extends JpaRepository<CarRegistration, String>{
		
	List<CarRegistration> findByEmailid(String emailid);

}
