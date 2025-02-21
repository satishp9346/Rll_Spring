package com.mphasis.RealEstateManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
