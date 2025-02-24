package com.mphasis.RealEstateManagementSystem.dto;

public class PropertyManagerDTO {
    private String name;
    private String contact;
    private String email;

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

	@Override
	public String toString() {
		return "PropertyManagerDTO [name=" + name + ", contact=" + contact + ", email=" + email + "]";
	}
    
}

