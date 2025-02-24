package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.repository.BuyerRepository;

@Service
public class BuyerService {
	@Autowired
	BuyerRepository buyerRepo;
	public List<Buyer> getAllBuyer(){
		return buyerRepo.findAll();
	}
	public Buyer getBuyer(int buyerId) {
		if(buyerRepo.existsById(buyerId)) 
			return buyerRepo.findById(buyerId).get();
		return null;
	}
	public Buyer addBuyer(Buyer buyer) {
		if(buyerRepo.save(buyer)!=null)
			return buyer;
		return null;
	}
	public Buyer updateBuyer(Buyer buyer) {
		if(buyerRepo.existsById(buyer.getBuyerId()))
			return buyerRepo.save(buyer);
		return null;
	}
	public Buyer deleteBuyer(int buyerId) {
		if(buyerRepo.existsById(buyerId)){
			Buyer buyer=buyerRepo.findById(buyerId).get();
			buyerRepo.deleteById(buyerId);
			return buyer;
		}
		return null;
	}


}
