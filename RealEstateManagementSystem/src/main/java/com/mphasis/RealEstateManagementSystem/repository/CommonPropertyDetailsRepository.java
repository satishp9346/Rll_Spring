package com.mphasis.RealEstateManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;


@Repository
public interface CommonPropertyDetailsRepository extends JpaRepository<CommonPropertyDetails, Integer> {

}
