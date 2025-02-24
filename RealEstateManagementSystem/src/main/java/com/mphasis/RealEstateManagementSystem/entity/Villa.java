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
@Table(name = "individual_house_tbl")
public class Villa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idividualId;
	@Column(length = 50)
	String type;
	int baths;
	@Column(length = 50)
	String ageOfConstruction;
	@Column(length = 50)
	String waterAvailability;
	@Column(length = 50)
	String statusOfElectricity;
	@Column(length = 50)
	String furnishedStatus;//furnished/un furnished
	int balconies;
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


	@Override
	public String toString() {
		return "Villa [idividualId=" + idividualId + ", type=" + type + ", baths=" + baths + ", ageOfConstruction="
				+ ageOfConstruction + ", waterAvailability=" + waterAvailability + ", statusOfElectricity="
				+ statusOfElectricity + ", furnishedStatus=" + furnishedStatus + ", balconies=" + balconies
				+ ", viwedBy=" + viwedBy + ", favFor=" + favFor + ", seller=" + seller + ", buyer=" + buyer
				+ ", commPropDetails=" + commPropDetails + "]";
	}

	public Villa() {
		super();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public int getBalconies() {
		return balconies;
	}

	public void setBalconies(int balconies) {
		this.balconies = balconies;
	}

	public int getIdividualId() {
		return idividualId;
	}

	public void setIdividualId(int idividualId) {
		this.idividualId = idividualId;
	}

	public CommonPropertyDetails getCommPropDetails() {
		return commPropDetails;
	}

	public void setCommPropDetails(CommonPropertyDetails commPropDetails) {
		this.commPropDetails = commPropDetails;
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
	public String getAgeOfConstruction() {
		return ageOfConstruction;
	}
	public void setAgeOfConstruction(String ageOfConstruction) {
		this.ageOfConstruction = ageOfConstruction;
	}
	public String getWaterAvailability() {
		return waterAvailability;
	}
	public void setWaterAvailability(String waterAvailability) {
		this.waterAvailability = waterAvailability;
	}
	public String getStatusOfElectricity() {
		return statusOfElectricity;
	}
	public void setStatusOfElectricity(String statusOfElectricity) {
		this.statusOfElectricity = statusOfElectricity;
	}
	public String getFurnishedStatus() {
		return furnishedStatus;
	}
	public void setFurnishedStatus(String furnishedStatus) {
		this.furnishedStatus = furnishedStatus;
	}

	
	
	

}
