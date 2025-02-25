package com.mphasis.RealEstateManagementSystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_tbl")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int adminId;
	@OneToOne(cascade = CascadeType.ALL)
	UserCommonDetails userComDet;
	@OneToMany(cascade = CascadeType.ALL)
	List<Seller> sellerList;
	@OneToMany(cascade = CascadeType.ALL)
	List<PropertyManager> propManagerList;
	@OneToMany(cascade = CascadeType.ALL)
	List<Buyer> buyerList;
	@OneToOne(cascade = CascadeType.ALL)
	User user;
	
	public Admin() {
		super();
	}
	
	public Admin(int adminId, UserCommonDetails userComDet, List<Seller> sellerList,
			List<PropertyManager> propManagerList, List<Buyer> buyerList, User user) {
		super();
		this.adminId = adminId;
		this.userComDet = userComDet;
		this.sellerList = sellerList;
		this.propManagerList = propManagerList;
		this.buyerList = buyerList;
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public UserCommonDetails getUserComDet() {
		return userComDet;
	}
	public void setUserComDet(UserCommonDetails userComDet) {
		this.userComDet = userComDet;
	}
	public List<Seller> getSellerList() {
		return sellerList;
	}
	public void setSellerList(List<Seller> sellerList) {
		this.sellerList = sellerList;
	}
	public List<PropertyManager> getPropManagerList() {
		return propManagerList;
	}
	public void setPropManagerList(List<PropertyManager> propManagerList) {
		this.propManagerList = propManagerList;
	}
	public List<Buyer> getBuyerList() {
		return buyerList;
	}
	public void setBuyerList(List<Buyer> buyerList) {
		this.buyerList = buyerList;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userComDet=" + userComDet + ", sellerList=" + sellerList
				+ ", propManagerList=" + propManagerList + ", buyerList=" + buyerList + ", user=" + user + "]";
	}

	
	
	

	

}
