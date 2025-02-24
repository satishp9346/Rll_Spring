package com.mphasis.RealEstateManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.RealEstateManagementSystem.dto.ApartmentDTO;
import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.service.ApartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apartment")
public class ApartmentController {
	@Autowired
	ApartmentService aprtServ;
	@PostMapping("/add")
	public ResponseEntity<?> addApartment(@RequestBody ApartmentDTO apartment) {
		System.out.println(apartment);
		if(aprtServ.addApartment(apartment)!=null)
			return new ResponseEntity<ApartmentDTO>(apartment,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Apartment Id Already Exists.",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/addToFav")
    public String addToFav(@RequestParam int apartmentId, @RequestParam int buyerId) {
        aprtServ.addBuyerToFavFor(apartmentId, buyerId);
        return "Buyer added to favorites successfully.";
    }
	@GetMapping("/favFor/{buyerId}")
    public List<Apartment> getVillaByBuyerIdInFavFor(@PathVariable int buyerId) {
        return aprtServ.getVillaByBuyerIdInFavFor(buyerId);
    }
	@GetMapping("/viewed/{buyerId}")
    public List<Apartment> getApartByBuyerIdInViewedBy(@PathVariable int buyerId) {
        return aprtServ.getApartByBuyerIdInViewedBy(buyerId);
    }

    @PutMapping("/addToViewed")
    public String addToViewedBy(@RequestParam int apartmentId, @RequestParam int buyerId) {
        aprtServ.addBuyerToViewedBy(apartmentId, buyerId);
        return "Buyer added to viewed list successfully.";
    }
//	 @PutMapping("/updateBuyer")
//    public String updateBuyerForApartment(@RequestParam int apartmentId, @RequestParam int buyerId) {
//        int updatedRows = aprtServ.updateBuyerForApartment(apartmentId, buyerId);
//        if (updatedRows > 0) {
//            return "Buyer updated successfully.";
//        } else {
//            return "Failed to update buyer.";
//        }
//    }
//	 @PutMapping("/addToFav")
//	    public String addToFav(@RequestParam int apartmentId, @RequestParam int buyerId) {
//	        int updatedRows = aprtServ.addBuyerToFavFor(apartmentId, buyerId);
//	        return updatedRows > 0 ? "Buyer added to favorites successfully." : "Failed to add buyer to favorites.";
//	    }
//
//	    @PutMapping("/addToViewed")
//	    public String addToViewedBy(@RequestParam int apartmentId, @RequestParam int buyerId) {
//	        int updatedRows = aprtServ.addBuyerToViewedBy(apartmentId, buyerId);
//	        return updatedRows > 0 ? "Buyer added to viewed list successfully." : "Failed to add buyer to viewed list.";
//	    }
//	 @PostMapping("/add")
//	    public ResponseEntity<?> addApartment(@RequestPart("apartment") ApartmentDTO apartmentDTO,
//	                                          @RequestPart("commonPropertyDetailsDTO.images") List<MultipartFile> imageFiles) {
//	        apartmentDTO.getCommonPropertyDetails().setImages(imageFiles);
//	        Apartment newApartment = aprtServ.addApartment(apartmentDTO);
//	        if (newApartment != null) {
//	            return new ResponseEntity<Apartment>(newApartment, HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<String>("Sorry, Apartment could not be added.", HttpStatus.NOT_FOUND);
//	        }
//	    }
	@GetMapping("/search_by_city")
	public ResponseEntity<?> searchPropertyByCity(String city) {
		List<Apartment> aprtList=aprtServ.searchPropertyByCity(city);
		if(!aprtList.isEmpty())
			return new ResponseEntity<List<Apartment>>(aprtList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Apartments Exists.",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateApartment(@PathVariable("id") int apartmentId, @RequestBody Apartment apartment) {
		if(aprtServ.getApartment(apartmentId).getApartmentId()==apartmentId) {
			aprtServ.updateApartment(apartment);
			return new ResponseEntity<Apartment>(apartment,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Sorry Apartment does not Exists.",HttpStatus.NOT_FOUND);
	}
	  @PutMapping("/{apartmentId}/sell")
	    public ResponseEntity<String> markApartmentAsSold(
	            @PathVariable int apartmentId,
	            @RequestBody Buyer buyer) {
	        
	        aprtServ.markApartmentAsSold(apartmentId, buyer);
	        return ResponseEntity.ok("Apartment marked as sold and buyer assigned successfully.");
	    }
	@GetMapping("")
	public ResponseEntity<?> getAllApartments() {
		List<Apartment> aprtList=aprtServ.getAllApartment();
		if(!aprtList.isEmpty())
			return new ResponseEntity<List<Apartment>>(aprtList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Apartments Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/unsold")
	public ResponseEntity<?> getUnsoldApartments() {
		List<Apartment> aprtList=aprtServ.getUnsoldApartments();
		if(!aprtList.isEmpty())
			return new ResponseEntity<List<Apartment>>(aprtList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Apartments Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getApartment(@PathVariable("id") int apartmentId) {
		Apartment apartment=aprtServ.getApartment(apartmentId);
		if(apartment!=null)
			return new ResponseEntity<Apartment>(apartment,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Apartment does not Exists.",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteApartment(@PathVariable("id") int apartmentId) {
		Apartment apartment=aprtServ.deleteApartment(apartmentId);
		if(apartment!=null)
			return new ResponseEntity<Apartment>(apartment,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Apartment does not Exists.",HttpStatus.NOT_FOUND);
	}
}
