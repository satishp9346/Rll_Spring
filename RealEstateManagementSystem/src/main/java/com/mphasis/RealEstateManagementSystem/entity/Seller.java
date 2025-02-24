package com.mphasis.RealEstateManagementSystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seller_tbl")
public class Seller{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sellerId;
	@OneToOne(cascade = CascadeType.ALL)
	UserCommonDetails userCommonDetails;
	@ManyToOne
	PropertyManager property_manager;
	@OneToMany(mappedBy = "seller")
	@JsonIgnore
	List<Plots> poltsList;
	@OneToMany(mappedBy = "seller")
	@JsonIgnore
	List<Apartment> aprtList;
	@OneToMany(mappedBy = "seller")
	@JsonIgnore
	List<Villa> indList;
	@OneToOne(cascade = CascadeType.ALL)
	User user;

	
	public Seller(int sellerId, UserCommonDetails userCommonDetails, PropertyManager property_manager,
			List<Plots> poltsList, List<Apartment> aprtList, List<Villa> indList, User user) {
		super();
		this.sellerId = sellerId;
		this.userCommonDetails = userCommonDetails;
		this.property_manager = property_manager;
		this.poltsList = poltsList;
		this.aprtList = aprtList;
		this.indList = indList;
		this.user = user;
	}
	public Seller() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public UserCommonDetails getUserCommonDetails() {
		return userCommonDetails;
	}
	public void setUserCommonDetails(UserCommonDetails userCommonDetails) {
		this.userCommonDetails = userCommonDetails;
	}
	public PropertyManager getProperty_manager() {
		return property_manager;
	}
	public void setProperty_manager(PropertyManager property_manager) {
		this.property_manager = property_manager;
	}
	public List<Plots> getPoltsList() {
		return poltsList;
	}
	public void setPoltsList(List<Plots> poltsList) {
		this.poltsList = poltsList;
	}
	public List<Apartment> getAprtList() {
		return aprtList;
	}
	public void setAprtList(List<Apartment> aprtList) {
		this.aprtList = aprtList;
	}
	public List<Villa> getIndList() {
		return indList;
	}
	public void setIndList(List<Villa> indList) {
		this.indList = indList;
	}
	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", userCommonDetails=" + userCommonDetails + ", property_manager="
				+ property_manager + ", poltsList=" + poltsList + ", aprtList=" + aprtList + ", indList=" + indList
				+ ", user=" + user + "]";
	}
	
	
	
	
	
}
