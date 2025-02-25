package com.mphasis.RealEstateManagementSystem.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.RealEstateManagementSystem.dto.ApartmentDTO;
import com.mphasis.RealEstateManagementSystem.dto.CommonPropertyDetailsDTO;
import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.ImageData;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.entity.User;
import com.mphasis.RealEstateManagementSystem.entity.UserCommonDetails;
import com.mphasis.RealEstateManagementSystem.repository.ApartmentRepository;
import com.mphasis.RealEstateManagementSystem.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class ApartmentService {
	@Autowired
	ApartmentRepository apartRepo;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private EntityManager entityManager;

	public List<Apartment> getAllApartment() {
		return apartRepo.findAll();
	}

	public Apartment getApartment(int apartmentId) {
		if (apartRepo.existsById(apartmentId))
			return apartRepo.findById(apartmentId).get();
		return null;
	}
//	 @Transactional
//	public int updateBuyerForApartment(int apartmentId, int buyerId) {
//		return apartRepo.updateBuyerForApartment(apartmentId, buyerId);
//	}
//	 @Transactional
//    public int addBuyerToFavFor(int apartmentId, int buyerId) {
//        return apartRepo.addBuyerToFavFor(apartmentId, buyerId);
//    }
//
//    @Transactional
//    public int addBuyerToViewedBy(int apartmentId, int buyerId) {
//        return apartRepo.addBuyerToViewedBy(apartmentId, buyerId);
//    }
	@Transactional
    public void addBuyerToFavFor(int apartmentId, int buyerId) {
        Apartment apartment = apartRepo.findById(apartmentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid apartment ID"));
        apartment.getFavFor().add(buyerId);
        apartRepo.save(apartment);
    }

    @Transactional
    public void addBuyerToViewedBy(int apartmentId, int buyerId) {
        Apartment apartment = apartRepo.findById(apartmentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid apartment ID"));
        apartment.getViwedBy().add(buyerId);
        apartRepo.save(apartment);
    }
    public List<Apartment> getVillaByBuyerIdInFavFor(int buyerId) {
        return apartRepo.getVillaByBuyerIdInFavFor(buyerId);
    }
    public List<Apartment> getApartByBuyerIdInViewedBy(int buyerId) {
    	return apartRepo.getApartByBuyerIdInViewedBy(buyerId);
	}

	@Transactional
	public Apartment addApartment(ApartmentDTO apartmentDTO) {
		System.out.println(apartmentDTO);

		PropertyManager propertyManager = apartmentDTO.getPropertyManager();

		User userPropManager = propertyManager.getUser();
		propertyManager.setUser(entityManager.merge(userPropManager));
		apartmentDTO.setPropertyManager(entityManager.merge(propertyManager));

		// Fetch existing Seller using User's email
		String userEmail = apartmentDTO.getSeller().getUser().getEmail();
		TypedQuery<Seller> query = entityManager.createQuery("SELECT s FROM Seller s WHERE s.user.email = :email",
				Seller.class);
		query.setParameter("email", userEmail);

		Seller seller;
		try {
			seller = query.getSingleResult();
		} catch (NoResultException e) {
			throw new RuntimeException("Seller not found with email: " + userEmail);
		}
		Apartment apartment = new Apartment();
		apartment.setApartmentName(apartmentDTO.getApartmentName());
		apartment.setBaths(apartmentDTO.getBaths());
		apartment.setType(apartmentDTO.getType());
		apartment.setFloorNo(apartmentDTO.getFloorNo());
		apartment.setNoOfLifts(apartmentDTO.getNoOfLifts());
		apartment.setFurnishedStatus(apartmentDTO.getFurnishedStatus());
		apartment.setAgeOfConstruction(apartmentDTO.getAgeOfConstruction());
		apartment.setWaterAvailability(apartmentDTO.getWaterAvailability());
		apartment.setStatusOfElectricity(apartmentDTO.getStatusOfElectricity());
		apartment.setAuthorityApproval(apartmentDTO.getAuthorityApproval());
		apartment.setBalconies(apartmentDTO.getBalconies());
		apartment.setCommPropDetails(apartmentDTO.getCommonPropertyDetails());

		apartment.setSeller(seller);
		seller.setProperty_manager(apartmentDTO.getPropertyManager());
		apartment.setBuyer(apartmentDTO.getBuyer());
		if (apartRepo.save(apartment) != null)
			return apartment;
		return null;
	}
	@Transactional
	public void markApartmentAsSold(int apartmentId, Buyer buyer) {
//	    int updatedRows = apartRepo.updateApartmentSoldStatusAndBuyer(apartmentId, buyer);
//	    if (updatedRows == 0) {
//	        throw new RuntimeException("Apartment not found or already sold");
//	    }
	    Apartment apartment = apartRepo.findById(apartmentId)
	            .orElseThrow(() -> new RuntimeException("Apartment not found"));

	    // Ensure the Buyer exists in the database
	    Buyer existingBuyer = entityManager.find(Buyer.class, buyer.getBuyerId());
	    
	    if (existingBuyer == null) {
	        // If Buyer is not found, persist it first
	        existingBuyer = entityManager.merge(buyer);
	    }

	    apartment.setBuyer(existingBuyer);
	    apartment.getCommPropDetails().setSoldStatus("sold");

	    apartRepo.save(apartment);

	}
	public List<Apartment> getUnsoldApartments(){
		return apartRepo.getUnsoldApartments();
	}
	public List<Apartment> getSoldApartments(int buyerId){
		return apartRepo.getSoldApartments(buyerId);
	}
	public Apartment updateApartment(Apartment apartment) {
		if (apartRepo.existsById(apartment.getApartmentId()))
			return apartRepo.save(apartment);
		return null;
	}

	public Apartment deleteApartment(int apartmentId) {
		if (apartRepo.existsById(apartmentId)) {
			Apartment apartment = apartRepo.findById(apartmentId).get();
			apartRepo.deleteById(apartmentId);
			return apartment;
		}
		return null;
	}

	public List<Apartment> searchPropertyByCity(String city) {
		return apartRepo.searchPropertyByCity(city);
	}

	
}
