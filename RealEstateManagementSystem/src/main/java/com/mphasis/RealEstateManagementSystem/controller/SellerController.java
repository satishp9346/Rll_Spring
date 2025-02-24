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

import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.service.SellerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	SellerService sellerServ;
	@PostMapping("/add")
	public ResponseEntity<?> addSeller(@RequestBody Seller seller) {
		if(sellerServ.addSeller(seller)!=null)
			return new ResponseEntity<Seller>(seller,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Seller Id Already Exists.",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateSeller(@PathVariable("id") int sellerId, @RequestBody Seller seller) {
		if(sellerServ.getSeller(sellerId).getSellerId()==sellerId) {
			sellerServ.updateSeller(seller);
			return new ResponseEntity<Seller>(seller,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Sorry Seller does not Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public ResponseEntity<?> getAllSellers() {
		List<Seller> sellerList=sellerServ.getAllSeller();
		if(!sellerList.isEmpty())
			return new ResponseEntity<List<Seller>>(sellerList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Sellers Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getSeller(@PathVariable("id") int sellerId) {
		Seller seller=sellerServ.getSeller(sellerId);
		if(seller!=null)
			return new ResponseEntity<Seller>(seller,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Seller does not Exists.",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteSeller(@PathVariable("id") int sellerId) {
		Seller seller=sellerServ.deleteSeller(sellerId);
		if(seller!=null)
			return new ResponseEntity<Seller>(seller,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Seller does not Exists.",HttpStatus.NOT_FOUND);
	}
}
