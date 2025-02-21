package com.mphasis.RealEstateManagementSystem.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
	@Query("FROM Apartment a WHERE a.commPropDetails.soldStatus = 'unsold'")
    List<Apartment> findApartmentsByStatus();
	
	@Query("FROM Apartment a WHERE a.commPropDetails.address.city LIKE %:city%")
	List<Apartment> searchPropertyByCity(@Param("city") String city);

}
