package com.mphasis.RealEstateManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Villa;

@Repository
public interface VillaRepository extends JpaRepository<Villa, Integer> {
	@Query("FROM Villa a WHERE a.commPropDetails.soldStatus = 'unsold'")
    List<Villa> findVillaByStatus();
	
	@Query("FROM Villa v WHERE v.commPropDetails.address.city LIKE %:city%")
	List<Villa> searchPropertyByCity(@Param("city") String city);
	
	@Query("SELECT a FROM Villa a WHERE a.commPropDetails.soldStatus = 'unsold'")
	List<Villa> getUnsoldVillas();
	
}
