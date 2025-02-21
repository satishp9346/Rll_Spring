package com.mphasis.RealEstateManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_tbl")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	@Column(length = 50)
	private String doorNum;
	@Column(length = 100)
	private String street;
	@Column(length = 50)
	private String city;
	@Column(length = 50)
	private String district;
	@Column(length = 50)
	private String pinCode;
	@Column(length = 50)
	private String state;
	@Column(length = 50)
	private String country;
	

	
	public Address(int addressId, String doorNum, String street, String city, String district, String pinCode,
			String state, String country) {
		super();
		this.addressId = addressId;
		this.doorNum = doorNum;
		this.street = street;
		this.city = city;
		this.district = district;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
	}
	public Address() {
		super();
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDoorNum() {
		return doorNum;
	}
	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", doorNum=" + doorNum + ", street=" + street + ", city=" + city
				+ ", district=" + district + ", pinCode=" + pinCode + ", state=" + state + ", country=" + country + "]";
	}
	
	
	
	
	
}
