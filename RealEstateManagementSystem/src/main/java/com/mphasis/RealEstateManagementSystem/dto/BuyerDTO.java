package com.mphasis.RealEstateManagementSystem.dto;

public class BuyerDTO {
	private String name;
    private String contact;
    private String email;
    private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BuyerDTO(String name, String contact, String email, String address) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.address = address;
	}
	public BuyerDTO() {
		super();
	}
	@Override
	public String toString() {
		return "BuyerDTO [name=" + name + ", contact=" + contact + ", email=" + email + ", address=" + address + "]";
	}
    
}
