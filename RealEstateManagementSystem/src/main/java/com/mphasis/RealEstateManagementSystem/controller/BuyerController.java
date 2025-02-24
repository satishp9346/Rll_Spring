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
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.service.BuyerService;


@CrossOrigin("*")
@RestController
@RequestMapping("/buyer")
public class BuyerController {
	@Autowired
	BuyerService buyerServ;
	@PostMapping("/add")
	public ResponseEntity<?> addBuyer(@RequestBody Buyer buyer) {
		if(buyerServ.addBuyer(buyer)!=null)
			return new ResponseEntity<Buyer>(buyer,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Buyer Id Already Exists.",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBuyer(@PathVariable("id") int buyerId, @RequestBody Buyer buyer) {
		if(buyerServ.getBuyer(buyerId).getBuyerId()==buyerId) {
			buyerServ.updateBuyer(buyer);
			return new ResponseEntity<Buyer>(buyer,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Sorry Buyer does not Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public ResponseEntity<?> getAllBuyers() {
		List<Buyer> buyerList=buyerServ.getAllBuyer();
		if(!buyerList.isEmpty())
			return new ResponseEntity<List<Buyer>>(buyerList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Buyers Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBuyer(@PathVariable("id") int buyerId) {
		Buyer buyer=buyerServ.getBuyer(buyerId);
		if(buyer!=null)
			return new ResponseEntity<Buyer>(buyer,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Buyer does not Exists.",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteBuyer(@PathVariable("id") int buyerId) {
		Buyer buyer=buyerServ.deleteBuyer(buyerId);
		if(buyer!=null)
			return new ResponseEntity<Buyer>(buyer,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Buyer does not Exists.",HttpStatus.NOT_FOUND);
	}
}
