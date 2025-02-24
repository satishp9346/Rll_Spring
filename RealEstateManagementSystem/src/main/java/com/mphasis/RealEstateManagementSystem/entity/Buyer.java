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
@Table(name = "buyer_tbl")
public class Buyer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int buyerId;
	@OneToOne(cascade = CascadeType.ALL)
	UserCommonDetails userCommonDetails;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	PropertyManager property_manager;
	@OneToMany(mappedBy = "buyer")
	@JsonIgnore
	List<Plots> plotsList;
	@OneToMany(mappedBy = "buyer")
	@JsonIgnore
	List<Apartment> aprtList;
	@OneToMany(mappedBy = "buyer")
	@JsonIgnore
	List<Villa> indList;
	@OneToOne(cascade = CascadeType.ALL)
	User user;

	
	public Buyer(int buyerId, UserCommonDetails userCommonDetails, PropertyManager property_manager,
			List<Plots> plotsList, List<Apartment> aprtList, List<Villa> indList, User user) {
		super();
		this.buyerId = buyerId;
		this.userCommonDetails = userCommonDetails;
		this.property_manager = property_manager;
		this.plotsList = plotsList;
		this.aprtList = aprtList;
		this.indList = indList;
		this.user = user;
	}
	public Buyer() {
		super();
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	
	public UserCommonDetails getUserCommonDetails() {
		return userCommonDetails;
	}
	public void setUserCommonDetails(UserCommonDetails userCommonDetails) {
		this.userCommonDetails = userCommonDetails;
	}
	public List<Plots> getPlotsList() {
		return plotsList;
	}
	public void setPlotsList(List<Plots> plotsList) {
		this.plotsList = plotsList;
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
	public PropertyManager getProperty_manager() {
		return property_manager;
	}
	public void setProperty_manager(PropertyManager property_manager) {
		this.property_manager = property_manager;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", userCommonDetails=" + userCommonDetails + ", property_manager="
				+ property_manager + ", plotsList=" + plotsList + ", aprtList=" + aprtList + ", indList=" + indList
				+ ", user=" + user + "]";
	}
	
	
	
	
	
	
}
