package com.mphasis.RealEstateManagementSystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int userId;
	@Column(unique = true,nullable = false,length = 30)
	String email;
	@Column(length = 30)
	String password;
	@Column(length = 30)
	String role;
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	Admin admin;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Seller> seller;
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	PropertyManager property_manager;
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	Buyer buyer;
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", role=" + role + ", admin="
				+ admin + ", seller=" + seller + ", property_manager=" + property_manager + ", buyer=" + buyer + "]";
	}

	public User() {
		super();
	}

	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public List<Seller> getSeller() {
		return seller;
	}
	public void setSeller(List<Seller> seller) {
		this.seller = seller;
	}
	public PropertyManager getProperty_manager() {
		return property_manager;
	}
	public void setProperty_manager(PropertyManager property_manager) {
		this.property_manager = property_manager;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

	

}
