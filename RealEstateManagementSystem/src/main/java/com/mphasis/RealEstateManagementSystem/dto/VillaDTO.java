package com.mphasis.RealEstateManagementSystem.dto;

import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.Seller;


public class VillaDTO {
	String type;
	int baths;
	String ageOfConstruction;
	String waterAvailability;
	String statusOfElectricity;
	String furnishedStatus;//furnished/un furnished
	int balconies;
	private CommonPropertyDetails commonPropertyDetails;
    private Seller seller;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBaths() {
		return baths;
	}
	public void setBaths(int baths) {
		this.baths = baths;
	}
	public String getAgeOfConstruction() {
		return ageOfConstruction;
	}
	public void setAgeOfConstruction(String ageOfConstruction) {
		this.ageOfConstruction = ageOfConstruction;
	}
	public String getWaterAvailability() {
		return waterAvailability;
	}
	public void setWaterAvailability(String waterAvailability) {
		this.waterAvailability = waterAvailability;
	}
	public String getStatusOfElectricity() {
		return statusOfElectricity;
	}
	public void setStatusOfElectricity(String statusOfElectricity) {
		this.statusOfElectricity = statusOfElectricity;
	}
	public String getFurnishedStatus() {
		return furnishedStatus;
	}
	public void setFurnishedStatus(String furnishedStatus) {
		this.furnishedStatus = furnishedStatus;
	}
	public int getBalconies() {
		return balconies;
	}
	public void setBalconies(int balconies) {
		this.balconies = balconies;
	}
	
	public CommonPropertyDetails getCommonPropertyDetails() {
		return commonPropertyDetails;
	}
	public void setCommonPropertyDetails(CommonPropertyDetails commonPropertyDetails) {
		this.commonPropertyDetails = commonPropertyDetails;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
    
}
