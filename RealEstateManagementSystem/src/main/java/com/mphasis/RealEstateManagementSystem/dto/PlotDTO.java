package com.mphasis.RealEstateManagementSystem.dto;


import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.entity.Seller;

public class PlotDTO {
	private String authorityApproval;
    private int floorsAllowed;
    private int noOfOpenSides; 
    private int boundaryWalls;
//    private CommonPropertyDetailsDTO commonPropertyDetails;
    private CommonPropertyDetails commonPropertyDetails;
    private Seller seller;
    private PropertyManager propertyManager;
    private Buyer buyer;
    
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



	public PropertyManager getPropertyManager() {
		return propertyManager;
	}



	public void setPropertyManager(PropertyManager propertyManager) {
		this.propertyManager = propertyManager;
	}



	public Buyer getBuyer() {
		return buyer;
	}



	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
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



	@Override
	public String toString() {
		return "PlotDTO [authorityApproval=" + authorityApproval + ", floorsAllowed=" + floorsAllowed
				+ ", noOfOpenSides=" + noOfOpenSides + ", boundaryWalls=" + boundaryWalls + ", commonPropertyDetails="
				+ commonPropertyDetails + ", seller=" + seller + ", propertyManager=" + propertyManager + ", buyer="
				+ buyer + "]";
	}



//	public CommonPropertyDetailsDTO getCommonPropertyDetails() {
//		return commonPropertyDetails;
//	}
//
//
//
//	public void setCommonPropertyDetails(CommonPropertyDetailsDTO commonPropertyDetails) {
//		this.commonPropertyDetails = commonPropertyDetails;
//	}

	






    
    
}
