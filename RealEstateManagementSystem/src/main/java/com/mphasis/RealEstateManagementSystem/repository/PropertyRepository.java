package com.mphasis.RealEstateManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;


public interface PropertyRepository extends JpaRepository<CommonPropertyDetails, Integer> {

}
