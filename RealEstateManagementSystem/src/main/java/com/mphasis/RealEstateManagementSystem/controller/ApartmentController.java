package com.mphasis.RealEstateManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.service.ApartmentService;


@RestController
@RequestMapping("/apartment")
public class ApartmentController {
	@Autowired
	ApartmentService aprtServ;
	@PostMapping("/add")
	public ResponseEntity<?> addApartment(@RequestBody Apartment apartment) {
		if(aprtServ.addApartment(apartment)!=null)
			return new ResponseEntity<Apartment>(apartment,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Apartment Id Already Exists.",HttpStatus.NOT_FOUND);
	}
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
	@GetMapping("")
	public ResponseEntity<?> getAllApartments() {
		List<Apartment> aprtList=aprtServ.getAllApartment();
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
