package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	SellerRepository sellerRepo;
	public List<Seller> getAllSeller(){
		return sellerRepo.findAll();
	}
	public Seller getSeller(int sellerId) {
		if(sellerRepo.existsById(sellerId)) 
			return sellerRepo.findById(sellerId).get();
		return null;
	}
	public Seller addSeller(Seller seller) {
		if(sellerRepo.save(seller)!=null)
			return seller;
		return null;
	}
	public Seller updateSeller(Seller seller) {
		if(sellerRepo.existsById(seller.getSellerId()))
			return sellerRepo.save(seller);
		return null;
	}
	public Seller deleteSeller(int sellerId) {
		if(sellerRepo.existsById(sellerId)){
			Seller seller=sellerRepo.findById(sellerId).get();
			sellerRepo.deleteById(sellerId);
			return seller;
		}
		return null;
	}

}
