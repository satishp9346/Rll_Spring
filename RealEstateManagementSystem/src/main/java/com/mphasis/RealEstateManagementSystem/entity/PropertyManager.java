package com.mphasis.RealEstateManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "property_manager_tbl")
public class PropertyManager{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int propManagerid;
	@OneToOne(cascade = CascadeType.ALL)
	UserCommonDetails ucd;
	@OneToMany(mappedBy = "property_manager",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Buyer> buyersList=new ArrayList<>();
	@OneToMany(mappedBy = "property_manager",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Seller> sellersList=new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL)
	User user;
	
	public PropertyManager(int propManagerid, UserCommonDetails ucd, List<Buyer> buyersList, List<Seller> sellersList,
			User user) {
		super();
		this.propManagerid = propManagerid;
		this.ucd = ucd;
		this.buyersList = buyersList;
		this.sellersList = sellersList;
		this.user = user;
	}
	public PropertyManager() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getPropManagerid() {
		return propManagerid;
	}
	public void setPropManagerid(int propManagerid) {
		this.propManagerid = propManagerid;
	}
	public UserCommonDetails getUcd() {
		return ucd;
	}
	public void setUcd(UserCommonDetails ucd) {
		this.ucd = ucd;
	}
	public List<Buyer> getBuyersList() {
		return buyersList;
	}
	public void setBuyersList(List<Buyer> buyersList) {
		this.buyersList = buyersList;
	}
	public List<Seller> getSellersList() {
		return sellersList;
	}
	public void setSellersList(List<Seller> sellersList) {
		this.sellersList = sellersList;
	}
	@Override
	public String toString() {
		return "PropertyManager [propManagerid=" + propManagerid + ", ucd=" + ucd + ", buyersList=" + buyersList
				+ ", sellersList=" + sellersList + ", user=" + user + "]";
	}
	
	
	
	
	
	

}
