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

import com.mphasis.RealEstateManagementSystem.dto.VillaDTO;
import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.service.VillaService;

@RestController
@RequestMapping("/villas")
public class VillasController {
	@Autowired
	VillaService villaService;
	@PostMapping("/add")
	public ResponseEntity<?> addIndividualHouse(@RequestBody VillaDTO villa) {
		if(villaService.addIndividualHouse(villa)!=null)
			return new ResponseEntity<VillaDTO>(villa,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry IndividualHouse Id Already Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/search_by_city")
	public ResponseEntity<?> searchPropertyByCity(String city) {
		List<Villa> villaList= villaService.searchPropertyByCity(city);
		if(!villaList.isEmpty())
			return new ResponseEntity<List<Villa>>(villaList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Villa Exists.",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateIndividualHouse(@PathVariable("id") int villaId, @RequestBody Villa villa) {
		if(villaService.getIndividualHouse(villaId).getIdividualId()==villaId) {
			villaService.updateIndividualHouse(villa);
			return new ResponseEntity<Villa>(villa,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Sorry IndividualHouse does not Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public ResponseEntity<?> getAllIndividualHouses() {
		List<Villa> individualList=villaService.getAllIndividualHouse();
		if(!individualList.isEmpty())
			return new ResponseEntity<List<Villa>>(individualList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No IndividualHouses Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getIndividualHouse(@PathVariable("id") int villaId) {
		Villa villa=villaService.getIndividualHouse(villaId);
		if(villa!=null)
			return new ResponseEntity<Villa>(villa,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry IndividualHouse does not Exists.",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteIndividualHouse(@PathVariable("id") int villaId) {
		Villa villa=villaService.deleteIndividualHouse(villaId);
		if(villa!=null)
			return new ResponseEntity<Villa>(villa,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry IndividualHouse does not Exists.",HttpStatus.NOT_FOUND);
	}
}
