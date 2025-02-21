package com.mphasis.RealEstateManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;

@Repository
public interface PropertyManagerRepository extends JpaRepository<PropertyManager, Integer> {
	@Query("SELECT b FROM PropertyManager b WHERE b.user.userId = :userId")
    Optional<PropertyManager> findByUserId(@Param("userId") int userId);
}
