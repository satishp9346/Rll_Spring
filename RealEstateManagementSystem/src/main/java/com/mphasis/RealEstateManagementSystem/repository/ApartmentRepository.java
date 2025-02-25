package com.mphasis.RealEstateManagementSystem.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.Plots;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
	@Query("FROM Apartment a WHERE a.commPropDetails.soldStatus = 'unsold'")
    List<Apartment> findApartmentsByStatus();
	
	@Query("FROM Apartment a WHERE a.commPropDetails.address.city LIKE %:city%")
	List<Apartment> searchPropertyByCity(@Param("city") String city);

	@Query("SELECT a FROM Apartment a WHERE a.commPropDetails.soldStatus = 'unsold'")
	List<Apartment> getUnsoldApartments();
	
	@Query("SELECT a FROM Apartment a WHERE a.buyer.buyerId=:buyerId AND a.commPropDetails.soldStatus = 'sold'")
	List<Apartment> getSoldApartments(@Param("buyerId") int buyerId);
	
	
	@Modifying
	@Query("UPDATE Apartment a SET a.commPropDetails.soldStatus = 'sold', a.buyer = :buyer WHERE a.apartmentId = :apartmentId")
	int updateApartmentSoldStatusAndBuyer(@Param("apartmentId") int apartmentId, @Param("buyer") Buyer buyer);
	
	@Query("SELECT v FROM Apartment v WHERE :buyerId MEMBER OF v.favFor")
    List<Apartment> getVillaByBuyerIdInFavFor(@Param("buyerId") int buyerId);
	
	@Query("SELECT v FROM Apartment v WHERE :buyerId MEMBER OF v.viwedBy")
	List<Apartment> getApartByBuyerIdInViewedBy(@Param("buyerId") int buyerId);
	
}
