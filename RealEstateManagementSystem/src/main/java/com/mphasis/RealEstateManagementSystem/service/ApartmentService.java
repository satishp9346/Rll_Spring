package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.repository.ApartmentRepository;


@Service
public class ApartmentService {
	@Autowired
	ApartmentRepository apartRepo;
	public List<Apartment> getAllApartment(){
		return apartRepo.findAll();
	}
	public Apartment getApartment(int apartmentId) {
		if(apartRepo.existsById(apartmentId)) 
			return apartRepo.findById(apartmentId).get();
		return null;
	}
	public Apartment addApartment(Apartment apartment) {
		if(apartRepo.save(apartment)!=null)
			return apartment;
		return null;
	}
	public Apartment updateApartment(Apartment apartment) {
		if(apartRepo.existsById(apartment.getApartmentId()))
			return apartRepo.save(apartment);
		return null;
	}
	public Apartment deleteApartment(int apartmentId) {
		if(apartRepo.existsById(apartmentId)){
			Apartment apartment=apartRepo.findById(apartmentId).get();
			apartRepo.deleteById(apartmentId);
			return apartment;
		}
		return null;
	}
	public List<Apartment> searchPropertyByCity(String city){
		return apartRepo.searchPropertyByCity(city);
	}

}
