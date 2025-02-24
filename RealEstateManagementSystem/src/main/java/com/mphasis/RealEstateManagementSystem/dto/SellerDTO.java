package com.mphasis.RealEstateManagementSystem.dto;

public class SellerDTO {
    private String name;
    private String contact;
    private String email;
    private String address;

    // Getters and Setters
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

	@Override
	public String toString() {
		return "SellerDTO [name=" + name + ", contact=" + contact + ", email=" + email + ", address=" + address + "]";
	}
    
}

