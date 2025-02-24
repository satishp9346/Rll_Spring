package com.mphasis.RealEstateManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.TempImages;

@Repository
public interface TempImageRepository extends JpaRepository<TempImages, Integer> {

}
