package com.mphasis.RealEstateManagementSystem.entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "apartmrnt_tbl")
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int apartmentId;
	@Column(length = 50)
	String apartmentName;
	int baths;
	@Column(length = 50)
	String type;//2 bhk,etc..
	int floorNo;
	int noOfLifts;
	@Column(length = 50)
	String furnishedStatus;//furnished/un furnished
	@Column(length = 50)
	String ageOfConstruction;
	@Column(length = 50)
	String waterAvailability;
	@Column(length = 50)
	String statusOfElectricity;
	@Column(length = 50)
	String authorityApproval;
	@Column(length = 50)
	String balconies;
	@ElementCollection
	List<Integer> viwedBy=new ArrayList<>();
	@ElementCollection
	List<Integer> favFor=new ArrayList<>();
	@ManyToOne(cascade = CascadeType.ALL)
	Seller seller;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	Buyer buyer;
	@OneToOne(cascade = CascadeType.ALL)
	CommonPropertyDetails commPropDetails;
	


	@Override
	public String toString() {
		return "Apartment [apartmentId=" + apartmentId + ", apartmentName=" + apartmentName + ", baths=" + baths
				+ ", type=" + type + ", floorNo=" + floorNo + ", noOfLifts=" + noOfLifts + ", furnishedStatus="
				+ furnishedStatus + ", ageOfConstruction=" + ageOfConstruction + ", waterAvailability="
				+ waterAvailability + ", statusOfElectricity=" + statusOfElectricity + ", authorityApproval="
				+ authorityApproval + ", balconies=" + balconies + ", viwedBy=" + viwedBy + ", favFor=" + favFor
				+ ", seller=" + seller + ", buyer=" + buyer + ", commPropDetails=" + commPropDetails + "]";
	}


	public Apartment() {
		super();
	}
	
	
	public List<Integer> getViwedBy() {
		return viwedBy;
	}


	public void setViwedBy(List<Integer> viwedBy) {
		this.viwedBy = viwedBy;
	}


	public List<Integer> getFavFor() {
		return favFor;
	}


	public void setFavFor(List<Integer> favFor) {
		this.favFor = favFor;
	}


	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public CommonPropertyDetails getCommPropDetails() {
		return commPropDetails;
	}

	public void setCommPropDetails(CommonPropertyDetails commPropDetails) {
		this.commPropDetails = commPropDetails;
	}

	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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
	
	public int getBaths() {
		return baths;
	}


	public void setBaths(int baths) {
		this.baths = baths;
	}


	public String getBalconies() {
		return balconies;
	}


	public void setBalconies(String balconies) {
		this.balconies = balconies;
	}


	public int getFloorNo() {
		return floorNo;
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







	
	

	

}
