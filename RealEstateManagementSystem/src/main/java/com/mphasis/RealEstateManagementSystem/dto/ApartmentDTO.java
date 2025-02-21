package com.mphasis.RealEstateManagementSystem.dto;

import com.mphasis.RealEstateManagementSystem.entity.Seller;

public class ApartmentDTO {
	
	String apartmentName;
	int baths;
	String type;//2 bhk,etc..
	int floorNo;
	int noOfLifts;
	String furnishedStatus;//furnished/un furnished
	String ageOfConstruction;
	String waterAvailability;
	String statusOfElectricity;
	String authorityApproval;
	String balconies;
    private CommonPropertyDetailsDTO commonPropertyDetails;
    private Seller seller;
    // Getters and Setters
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public int getBaths() {
		return baths;
	}
	public void setBaths(int baths) {
		this.baths = baths;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public int getNoOfLifts() {
		return noOfLifts;
	}
	public void setNoOfLifts(int noOfLifts) {
		this.noOfLifts = noOfLifts;
	}
	public String getFurnishedStatus() {
		return furnishedStatus;
	}
	public void setFurnishedStatus(String furnishedStatus) {
		this.furnishedStatus = furnishedStatus;
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
	public String getAuthorityApproval() {
		return authorityApproval;
	}
	public void setAuthorityApproval(String authorityApproval) {
		this.authorityApproval = authorityApproval;
	}
	public String getBalconies() {
		return balconies;
	}
	public void setBalconies(String balconies) {
		this.balconies = balconies;
	}
	public CommonPropertyDetailsDTO getCommonPropertyDetails() {
		return commonPropertyDetails;
	}
	public void setCommonPropertyDetails(CommonPropertyDetailsDTO commonPropertyDetails) {
		this.commonPropertyDetails = commonPropertyDetails;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
    
}
