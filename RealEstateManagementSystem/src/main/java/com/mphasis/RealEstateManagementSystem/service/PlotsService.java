package com.mphasis.RealEstateManagementSystem.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.RealEstateManagementSystem.dto.CommonPropertyDetailsDTO;
import com.mphasis.RealEstateManagementSystem.dto.PlotDTO;
import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.ImageData;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.entity.User;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.repository.PlotsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class PlotsService {
	@Autowired
	PlotsRepository plotsRepo;
	@Autowired
	private EntityManager entityManager;
	public List<Plots> getAllPlots(){
		return plotsRepo.findAll();
	}
	public Plots getPlots(int plotId) {
		if(plotsRepo.existsById(plotId)) 
			return plotsRepo.findById(plotId).get();
		return null;
	}
	@Transactional
    public void addBuyerToFavFor(int plotId, int buyerId) {
        Plots plot = plotsRepo.findById(plotId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid plots ID"));
        plot.getFavFor().add(buyerId);
        plotsRepo.save(plot);
    }
   public List<Plots> getVillaByBuyerIdInFavFor(int buyerId) {
        return plotsRepo.getVillaByBuyerIdInFavFor(buyerId);
    }
   public List<Plots> getPlotsByBuyerIdInViewedBy(int buyerId) {
       return plotsRepo.getPlotsByBuyerIdInViewedBy(buyerId);
   }

    @Transactional
    public void addBuyerToViewedBy(int plotId, int buyerId) {
        Plots plot = plotsRepo.findById(plotId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid plots ID"));
        plot.getViwedBy().add(buyerId);
        plotsRepo.save(plot);
    }
	@Transactional
	public Plots addPlots(PlotDTO plot) {
		System.out.println(plot);
		PropertyManager propertyManager = plot.getPropertyManager();

		User userPropManager = propertyManager.getUser();
		propertyManager.setUser(entityManager.merge(userPropManager));
		plot.setPropertyManager(entityManager.merge(propertyManager));

		// Fetch existing Seller using User's email
		String userEmail = plot.getSeller().getUser().getEmail();
		TypedQuery<Seller> query = entityManager.createQuery("SELECT s FROM Seller s WHERE s.user.email = :email",
				Seller.class);
		query.setParameter("email", userEmail);

		Seller seller;
		try {
			seller = query.getSingleResult();
		} catch (NoResultException e) {
			throw new RuntimeException("Seller not found with email: " + userEmail);
		}
		Plots plots=new Plots();
		plots.setAuthorityApproval(plot.getAuthorityApproval());
		plots.setFloorsAllowed(plot.getFloorsAllowed());
		plots.setNoOfOpenSides(plot.getNoOfOpenSides());
		plots.setBoundaryWalls(plot.getBoundaryWalls());
		plots.setCommPropDetails(plot.getCommonPropertyDetails());
		
		plots.setSeller(seller);
		seller.setProperty_manager(plot.getPropertyManager());
		
//		plots.setBuyer(plot.);
		if(plotsRepo.save(plots)!=null)
			return plots;
		return null;
	}
	
	public List<Plots> getUnsoldPlots(){
		return plotsRepo.getUnsoldPlots();
	}
	
	
//	public Plots addPlots(PlotDTO plotDTO) {
//        Plots plots = new Plots();
//        plots.setAuthorityApproval(plotDTO.getAuthorityApproval());
//        plots.setFloorsAllowed(plotDTO.getFloorsAllowed());
//        plots.setNoOfOpenSides(plotDTO.getNoOfOpenSides());
//        plots.setBoundaryWalls(plotDTO.getBoundaryWalls());
//
//        CommonPropertyDetailsDTO commonPropertyDetailsDTO = plotDTO.getCommonPropertyDetails();
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
//        for (MultipartFile file : commonPropertyDetailsDTO.getImages()) {
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
//        plots.setCommPropDetails(commonPropertyDetails);
//        plots.setSeller(plotDTO.getSeller());
//        plots.getSeller().setProperty_manager(plotDTO.getPropertyManager());
//        plots.setBuyer(plotDTO.getBuyer());
//
//        return plotsRepo.save(plots);
//    }
	public Plots updatePlots(Plots plot) {
		if(plotsRepo.existsById(plot.getPlotId()))
			return plotsRepo.save(plot);
		return null;
	}
	public Plots deletePlots(int plotId) {
		if(plotsRepo.existsById(plotId)){
			Plots plot=plotsRepo.findById(plotId).get();
			plotsRepo.deleteById(plotId);
			return plot;
		}
		return null;
	}
	public List<Plots> searchPropertyByCity(String city){
		return plotsRepo.searchPropertyByCity(city);
	}
}
