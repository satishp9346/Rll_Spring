package com.mphasis.RealEstateManagementSystem.dto;

import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
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
//    private CommonPropertyDetailsDTO commonPropertyDetails;
	  private CommonPropertyDetails commonPropertyDetails;
		
    private Seller seller;
    private PropertyManager propertyManager;
    private Buyer buyer;
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
	
	public CommonPropertyDetails getCommonPropertyDetails() {
		return commonPropertyDetails;
	}
	public void setCommonPropertyDetails(CommonPropertyDetails commonPropertyDetails) {
		this.commonPropertyDetails = commonPropertyDetails;
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
	
	public PropertyManager getPropertyManager() {
		return propertyManager;
	}
	public void setPropertyManager(PropertyManager propertyManager) {
		this.propertyManager = propertyManager;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	@Override
	public String toString() {
		return "ApartmentDTO [apartmentName=" + apartmentName + ", baths=" + baths + ", type=" + type + ", floorNo="
				+ floorNo + ", noOfLifts=" + noOfLifts + ", furnishedStatus=" + furnishedStatus + ", ageOfConstruction="
				+ ageOfConstruction + ", waterAvailability=" + waterAvailability + ", statusOfElectricity="
				+ statusOfElectricity + ", authorityApproval=" + authorityApproval + ", balconies=" + balconies
				+ ", commonPropertyDetails=" + commonPropertyDetails + ", seller=" + seller + ", propertyManager="
				+ propertyManager + ", buyer=" + buyer + "]";
	}
    
}
