package com.location.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	Location findByLocation(String location);

	void deleteByLocation(String location);
	
	Location findByLocationOrder(Integer locationOrder);
	
}
