package com.mphasis.RealEstateManagementSystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_common_details_tbl")
public class UserCommonDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userComId;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 50)
	private String gender;
	private int age;
	@Column(length = 10,unique = true,nullable = false)
	private String mobileNo;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	public UserCommonDetails() {
		super();
	}
	public UserCommonDetails(int userComId, String firstName, String lastName, String gender, int age, String mobileNo,
			Address address) {
		super();
		this.userComId = userComId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.mobileNo = mobileNo;
		this.address = address;
	}
	public int getUserComId() {
		return userComId;
	}
	public void setUserComId(int userComId) {
		this.userComId = userComId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserCommonDetails [userComId=" + userComId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", age=" + age + ", mobileNo=" + mobileNo + ", address=" + address + "]";
	}
	
	


}
