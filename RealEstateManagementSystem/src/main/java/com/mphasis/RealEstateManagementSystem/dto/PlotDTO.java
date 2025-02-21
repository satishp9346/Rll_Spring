package com.mphasis.RealEstateManagementSystem.dto;


import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.Seller;

public class PlotDTO {
	private String authorityApproval;
    private int floorsAllowed;
    private int noOfOpenSides; 
    private int boundaryWalls;
    private CommonPropertyDetails commonPropertyDetails;
    private Seller seller;
    
	public PlotDTO() {
		super();
	}
	


	public Seller getSeller() {
		return seller;
	}



	public void setSeller(Seller seller) {
		this.seller = seller;
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



	public CommonPropertyDetails getCommonPropertyDetails() {
		return commonPropertyDetails;
	}



	public void setCommonPropertyDetails(CommonPropertyDetails commonPropertyDetails) {
		this.commonPropertyDetails = commonPropertyDetails;
	}




    
    
}
