package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.dto.VillaDTO;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.repository.VillaRepository;

@Service
public class VillaService {
	@Autowired
	VillaRepository villaRepo;
	public List<Villa> getAllIndividualHouse(){
		return villaRepo.findAll();
	}
	public Villa getIndividualHouse(int individualId) {
		if(villaRepo.existsById(individualId)) 
			return villaRepo.findById(individualId).get();
		return null;
	}
	public Villa addIndividualHouse(VillaDTO villaDto) {
		Villa villa=new Villa();
		villa.setType(villaDto.getType());
		villa.setBaths(villaDto.getBaths());
		villa.setAgeOfConstruction(villaDto.getAgeOfConstruction());
		villa.setWaterAvailability(villaDto.getWaterAvailability());
		villa.setStatusOfElectricity(villaDto.getStatusOfElectricity());
		villa.setFurnishedStatus(villaDto.getFurnishedStatus());
		villa.setBalconies(villaDto.getBalconies());
		villa.setCommPropDetails(villaDto.getCommonPropertyDetails());
		villa.setSeller(villaDto.getSeller());
		if(villaRepo.save(villa)!=null)
			return villa;
		return null;
	}
	public Villa updateIndividualHouse(Villa indiHouse) {
		if(villaRepo.existsById(indiHouse.getIdividualId()))
			return villaRepo.save(indiHouse);
		return null;
	}
	public Villa deleteIndividualHouse(int individualId) {
		if(villaRepo.existsById(individualId)){
			Villa indiHouse=villaRepo.findById(individualId).get();
			villaRepo.deleteById(individualId);
			return indiHouse;
		}
		return null;
	}
	
	public List<Villa> searchPropertyByCity(String city){
		return villaRepo.searchPropertyByCity(city);
	}

}
