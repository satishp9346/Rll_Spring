package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.dto.VillaDTO;
import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.entity.User;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.repository.VillaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class VillaService {
	@Autowired
	VillaRepository villaRepo;
	@Autowired
	private EntityManager entityManager;

	public List<Villa> getAllIndividualHouse(){
		return villaRepo.findAll();
	}
	public Villa getIndividualHouse(int individualId) {
		if(villaRepo.existsById(individualId)) 
			return villaRepo.findById(individualId).get();
		return null;
	}
	@Transactional
    public void addBuyerToFavFor(int idividualId, int buyerId) {
        Villa villa = villaRepo.findById(idividualId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid villa ID"));
        villa.getFavFor().add(buyerId);
        villaRepo.save(villa);
    }

    @Transactional
    public void addBuyerToViewedBy(int idividualId, int buyerId) {
        Villa villa = villaRepo.findById(idividualId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid villa ID"));
        villa.getViwedBy().add(buyerId);
        villaRepo.save(villa);
    }
    public List<Villa> getVillaByBuyerIdInFavFor(int buyerId) {
        return villaRepo.getVillaByBuyerIdInFavFor(buyerId);
    }
    public List<Villa> getVillaByBuyerIdInViewedBy(int buyerId) {
        return villaRepo.getVillaByBuyerIdInViewedBy(buyerId);
    }
	@Transactional
	public Villa addVilla(VillaDTO villaDto) {
		System.out.println(villaDto);

		PropertyManager propertyManager = villaDto.getPropertyManager();

		User userPropManager = propertyManager.getUser();
		propertyManager.setUser(entityManager.merge(userPropManager));
		villaDto.setPropertyManager(entityManager.merge(propertyManager));

		// Fetch existing Seller using User's email
		String userEmail = villaDto.getSeller().getUser().getEmail();
		TypedQuery<Seller> query = entityManager.createQuery("SELECT s FROM Seller s WHERE s.user.email = :email",
				Seller.class);
		query.setParameter("email", userEmail);

		Seller seller;
		try {
			seller = query.getSingleResult();
		} catch (NoResultException e) {
			throw new RuntimeException("Seller not found with email: " + userEmail);
		}
		Villa villa=new Villa();
		villa.setType(villaDto.getType());
		villa.setBaths(villaDto.getBaths());
		villa.setAgeOfConstruction(villaDto.getAgeOfConstruction());
		villa.setWaterAvailability(villaDto.getWaterAvailability());
		villa.setStatusOfElectricity(villaDto.getStatusOfElectricity());
		villa.setFurnishedStatus(villaDto.getFurnishedStatus());
		villa.setBalconies(villaDto.getBalconies());
		villa.setCommPropDetails(villaDto.getCommonPropertyDetails());
		villa.setSeller(seller);
		seller.setProperty_manager(villaDto.getPropertyManager());
		if(villaRepo.save(villa)!=null)
			return villa;
		return null;
	}
	public List<Villa> getUnsoldVillas(){
		return villaRepo.getUnsoldVillas();
	}
	public List<Villa> getSoldVillas(int buyerId){
		return villaRepo.getSoldVillas(buyerId);
	}
//	public Villa addVilla(VillaDTO villaDTO) {
//        Villa villa = new Villa();
//        villa.setType(villaDTO.getType());
//        villa.setBaths(villaDTO.getBaths());
//        villa.setAgeOfConstruction(villaDTO.getAgeOfConstruction());
//        villa.setWaterAvailability(villaDTO.getWaterAvailability());
//        villa.setStatusOfElectricity(villaDTO.getStatusOfElectricity());
//        villa.setFurnishedStatus(villaDTO.getFurnishedStatus());
//        villa.setBalconies(villaDTO.getBalconies());
//
//        CommonPropertyDetailsDTO commonPropertyDetailsDTO = villaDTO.getCommonPropertyDetails();
//        CommonPropertyDetails commonPropertyDetails = new CommonPropertyDetails();
//
//        commonPropertyDetails.setCarpetArea(commonPropertyDetailsDTO.getCarpetArea());
//        commonPropertyDetails.setFacing(commonPropertyDetailsDTO.getFacing());
//        commonPropertyDetails.setPrice(commonPropertyDetailsDTO.getPrice());
//        commonPropertyDetails.setDescription(commonPropertyDetailsDTO.getDescription());
//        commonPropertyDetails.setStatus(commonPropertyDetailsDTO.getStatus());
//        commonPropertyDetails.setRegistrationCharges(commonPropertyDetailsDTO.getRegistrationCharges());
//        commonPropertyDetails.setBookingAmount(commonPropertyDetailsDTO.getBookingAmount());
//        commonPropertyDetails.setTransactionType(commonPropertyDetailsDTO.getTransactionType());
//        commonPropertyDetails.setDeveloper(commonPropertyDetailsDTO.getDeveloper());
//        commonPropertyDetails.setOverlooking(commonPropertyDetailsDTO.getOverlooking());
//        commonPropertyDetails.setSoldStatus(commonPropertyDetailsDTO.getSoldStatus());
//        commonPropertyDetails.setAddress(commonPropertyDetailsDTO.getAddress());
//        List<ImageData> imageDataList = new ArrayList<>();
//        for (MultipartFile file :commonPropertyDetailsDTO.getImages()) {
//            ImageData imageData = new ImageData();
//            try {
//                imageData.setImageData(file.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//                // Handle the exception
//            }
//            imageDataList.add(imageData);
//        }
//
//        commonPropertyDetails.setImages(imageDataList);
//        villa.setCommPropDetails(commonPropertyDetails);
//        villa.setSeller(villaDTO.getSeller());
//        villa.getSeller().setProperty_manager(villaDTO.getPropertyManager());
//        villa.setBuyer(villaDTO.getBuyer());
//
//        return villaRepo.save(villa);
//    }
	public Villa updateIndividualHouse(Villa indiHouse) {
		if(villaRepo.existsById(indiHouse.getIdividualId()))
			return villaRepo.save(indiHouse);
		return null;
	}
	public Villa deleteIndividualHouse(int individualId) {
		if(villaRepo.existsById(individualId)){
			Villa indiHouse=villaRepo.findById(individualId).get();
			villaRepo.deleteById(individualId);
			return indiHouse;
		}
		return null;
	}
	
	public List<Villa> searchPropertyByCity(String city){
		return villaRepo.searchPropertyByCity(city);
	}

}
