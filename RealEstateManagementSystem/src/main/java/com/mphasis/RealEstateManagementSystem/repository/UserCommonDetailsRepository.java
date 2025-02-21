package com.mphasis.RealEstateManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.UserCommonDetails;

@Repository
public interface UserCommonDetailsRepository extends JpaRepository<UserCommonDetails, Integer> {
	 
	@Query("FROM UserCommonDetails u WHERE u.userComId = :userComId")
	UserCommonDetails findByUserId(@Param("userComId") int userComId);

}
