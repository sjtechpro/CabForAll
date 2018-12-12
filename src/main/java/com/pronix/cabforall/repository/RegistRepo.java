package com.pronix.cabforall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pronix.cabforall.model.Registration;

@Repository
public interface RegistRepo extends JpaRepository<Registration, String> {

	final String logstatus = "select password from registration where emailid=?1";
	final String logdet = "select emailid from Registration where username=?1";
	final String checkEmailId = "select username from cabforall.Registration  where emailid=?1";

	@Query(value = logdet, nativeQuery = true)
	String findByUser(String username);

	@Query(value = logstatus, nativeQuery = true)
	String checkPswd(String emailid);

	@Query(value = checkEmailId, nativeQuery = true)
	String checkEmailExistance(String emailId);

	 

	public List<Registration> findByEmailid(String emailid);

}
