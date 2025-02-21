package com.mphasis.RealEstateManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer>{
	    @Query("SELECT s FROM Seller s WHERE s.user.userId = :userId")
	    Optional<Seller> findByUserId(@Param("userId") int userId);
}
