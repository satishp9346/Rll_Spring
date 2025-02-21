package com.mphasis.RealEstateManagementSystem.entity;

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
@Table(name = "common_property_details_tbl")
public class CommonPropertyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cpdId;
	
	double carpetArea;
	@Column(length = 50)
	String facing;
	double price;
	@Column(length = 500)
	String description;
	@Column(length = 50)
	String status;
	@Column(length = 50)
	String registrationCharges;
	@Column(length = 50)
	String bookingAmount;
	@Column(length = 50)
	String transactionType;
	@Column(length = 50)
	String developer;
	@Column(length = 50)
	String overlooking;
	public String getSoldStatus() {
		return soldStatus;
	}

	public void setSoldStatus(String soldStatus) {
		this.soldStatus = soldStatus;
	}

	@Column(length = 20)
	String soldStatus;
	@ElementCollection
	List<String> images;
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
	
	public CommonPropertyDetails() {
		super();
	}

	public int getCpdId() {
		return cpdId;
	}

	public void setCpdId(int cpdId) {
		this.cpdId = cpdId;
	}

	public double getCarpetArea() {
		return carpetArea;
	}

	public void setCarpetArea(double carpetArea) {
		this.carpetArea = carpetArea;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegistrationCharges() {
		return registrationCharges;
	}

	public void setRegistrationCharges(String registrationCharges) {
		this.registrationCharges = registrationCharges;
	}

	public String getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(String bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getOverlooking() {
		return overlooking;
	}

	public void setOverlooking(String overlooking) {
		this.overlooking = overlooking;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}



	
	

}
