package com.mphasis.RealEstateManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "plots_tbl")
public class Plots {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int plotId;
	@Column(length = 50)
	String authorityApproval;
	int floorsAllowed;
	int noOfOpenSides;
	int boundaryWalls;
	@ElementCollection
	List<Integer> viwedBy=new ArrayList<>();
	@ElementCollection
	List<Integer> favFor=new ArrayList<>();
	@ManyToOne(cascade = CascadeType.ALL)
	Seller seller;
	@ManyToOne(cascade = CascadeType.ALL)
	Buyer buyer;
	@OneToOne(cascade = CascadeType.ALL)
	CommonPropertyDetails commPropDetails;
	
	public Plots() {
		super();
	}	
	
	@Override
	public String toString() {
		return "Plots [plotId=" + plotId + ", authorityApproval=" + authorityApproval + ", floorsAllowed="
				+ floorsAllowed + ", noOfOpenSides=" + noOfOpenSides + ", boundaryWalls=" + boundaryWalls + ", viwedBy="
				+ viwedBy + ", favFor=" + favFor + ", seller=" + seller + ", buyer=" + buyer + ", commPropDetails="
				+ commPropDetails + "]";
	}

	public List<Integer> getViwedBy() {
		return viwedBy;
	}

	public void setViwedBy(List<Integer> viwedBy) {
		this.viwedBy = viwedBy;
	}

	public List<Integer> getFavFor() {
		return favFor;
	}

	public void setFavFor(List<Integer> favFor) {
		this.favFor = favFor;
	}

	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	public int getPlotId() {
		return plotId;
	}
	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}
	public CommonPropertyDetails getCommPropDetails() {
		return commPropDetails;
	}
	public void setCommPropDetails(CommonPropertyDetails commPropDetails) {
		this.commPropDetails = commPropDetails;
	}
	
	public String getAuthorityApproval() {
		return authorityApproval;
	}
	public void setAuthorityApproval(String authorityApproval) {
		this.authorityApproval = authorityApproval;
	}
	public int getFloorsAllowed() {
		return floorsAllowed;
	}
	public void setFloorsAllowed(int floorsAllowed) {
		this.floorsAllowed = floorsAllowed;
	}
	public int getNoOfOpenSides() {
		return noOfOpenSides;
	}
	public void setNoOfOpenSides(int noOfOpenSides) {
		this.noOfOpenSides = noOfOpenSides;
	}
	public int getBoundaryWalls() {
		return boundaryWalls;
	}
	public void setBoundaryWalls(int boundaryWalls) {
		this.boundaryWalls = boundaryWalls;
	}
	
	
	
	
	


}
