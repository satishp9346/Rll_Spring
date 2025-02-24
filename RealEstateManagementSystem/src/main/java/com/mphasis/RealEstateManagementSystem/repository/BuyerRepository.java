package com.mphasis.RealEstateManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
	@Query("SELECT b FROM Buyer b WHERE b.user.userId = :userId")
    Optional<Buyer> findByUserId(@Param("userId") int userId);

}
