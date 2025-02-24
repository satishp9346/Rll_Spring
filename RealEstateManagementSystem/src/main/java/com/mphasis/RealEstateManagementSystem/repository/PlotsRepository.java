package com.mphasis.RealEstateManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.Villa;

@Repository
public interface PlotsRepository extends JpaRepository<Plots, Integer> {
	@Query("FROM Plots a WHERE a.commPropDetails.soldStatus = 'unsold'")
    List<Plots> findPlotsByStatus();
	
	@Query("FROM Plots p WHERE p.commPropDetails.address.city LIKE %:city%")
	List<Plots> searchPropertyByCity(@Param("city") String city);

	@Query("SELECT a FROM Plots a WHERE a.commPropDetails.soldStatus = 'unsold'")
	List<Plots> getUnsoldPlots();
	
	@Query("SELECT v FROM Plots v WHERE :buyerId MEMBER OF v.favFor")
    List<Plots> getVillaByBuyerIdInFavFor(@Param("buyerId") int buyerId);
	
	@Query("SELECT v FROM Plots v WHERE :buyerId MEMBER OF v.viwedBy")
	List<Plots> getPlotsByBuyerIdInViewedBy(@Param("buyerId") int buyerId);
	
}
