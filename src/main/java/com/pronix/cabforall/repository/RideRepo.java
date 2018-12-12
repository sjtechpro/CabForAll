package com.pronix.cabforall.repository;

 
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pronix.cabforall.model.Ride;
@Repository
public interface RideRepo extends JpaRepository<Ride, String> {
	final String checkride = "SELECT * FROM cabforall.ride WHERE pickup =?1 AND dropoff =?2 AND startingdate=?3";
	final String checkExist = "select * from cabforall.ride where emailid=?1";
	final String saveStats="UPDATE cabforall.ride SET stats =?1 WHERE username=?2";
//	final String bookedStatus="SELECT registration.emailid, ride.stats,ride.username,ride.pickup,ride.dropoff,ride.startingdate,ride.returndate,ride.rate,ride.mobno,ride.seats,ride.stopovers FROM registration inner JOIN ride ON registration.emailid = ride.stats";
	final String bookedStatus="Select * from cabforall.ride where stats=?1";
	
	@Query(value = checkride, nativeQuery = true)
	List<Ride> checkride(String pickpoint, String droppoint, String dateofjourney);

	@Query(value = checkExist, nativeQuery = true)
	String findARide(String emailid);

	@Query(value = checkExist, nativeQuery = true)
	List<Ride> findExistRides(String emailid);
	
	@Query(value =bookedStatus, nativeQuery = true)
	List<Ride> bookedHistory(String stats);
	
	@Transactional
	@Modifying
	@Query(value = saveStats, nativeQuery = true)
	void bookStats(String emailid,String username);
	
	

}
