package com.mphasis.RealEstateManagementSystem.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mphasis.RealEstateManagementSystem.entity.Address;

public class CommonPropertyDetailsDTO {
	double carpetArea;
	String facing;
	double price;
	String description;
	String status;
	String registrationCharges;
	String bookingAmount;
	String transactionType;
	String developer;
	String overlooking;
	String soldStatus;
//	private List<MultipartFile> images;
	List<String> images;
	Address address;

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

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getOverlooking() {
		return overlooking;
	}

	public void setOverlooking(String overlooking) {
		this.overlooking = overlooking;
	}

	public String getSoldStatus() {
		return soldStatus;
	}

	public void setSoldStatus(String soldStatus) {
		this.soldStatus = soldStatus;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	// public List<MultipartFile> getImages() {
//		return images;
//	}
//	public void setImages(List<MultipartFile> images) {
//		this.images = images;
//	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CommonPropertyDetailsDTO [carpetArea=" + carpetArea + ", facing=" + facing + ", price=" + price
				+ ", description=" + description + ", status=" + status + ", registrationCharges=" + registrationCharges
				+ ", bookingAmount=" + bookingAmount + ", transactionType=" + transactionType + ", developer="
				+ developer + ", overlooking=" + overlooking + ", soldStatus=" + soldStatus + ", images=" + images
				+ ", address=" + address + "]";
	}

}
