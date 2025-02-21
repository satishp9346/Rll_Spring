package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.entity.Address;
import com.mphasis.RealEstateManagementSystem.repository.AddressRepository;


@Service
public class AddressService {
	@Autowired
	AddressRepository addrRepo;
	public List<Address> getAllAddress(){
		return addrRepo.findAll();
	}
	public Address getAddress(int addressId) {
		if(addrRepo.existsById(addressId)) 
			return addrRepo.findById(addressId).get();
		return null;
	}
	public Address addAddress(Address addr) {
		if(addrRepo.save(addr)!=null)
			return addr;
		return null;
	}
	public Address updateAddress(Address addr) {
		if(addrRepo.existsById(addr.getAddressId()))
			return addrRepo.save(addr);
		return null;
	}
	public Address deleteAddress(int addressId) {
		if(addrRepo.existsById(addressId)){
			Address addr=addrRepo.findById(addressId).get();
			addrRepo.deleteById(addressId);
			return addr;
		}
		return null;
	}
}
