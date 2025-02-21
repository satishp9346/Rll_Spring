package com.mphasis.RealEstateManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("SELECT b FROM Admin b WHERE b.user.userId = :userId")
    Optional<Admin> findByUserId(@Param("userId") int userId);
}
