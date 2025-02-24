package com.mphasis.RealEstateManagementSystem.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.dto.UserRequest;
import com.mphasis.RealEstateManagementSystem.entity.Admin;
import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.entity.User;
import com.mphasis.RealEstateManagementSystem.entity.UserCommonDetails;
import com.mphasis.RealEstateManagementSystem.repository.AdminRepository;
import com.mphasis.RealEstateManagementSystem.repository.BuyerRepository;
import com.mphasis.RealEstateManagementSystem.repository.PropertyManagerRepository;
import com.mphasis.RealEstateManagementSystem.repository.SellerRepository;
import com.mphasis.RealEstateManagementSystem.repository.UserCommonDetailsRepository;
import com.mphasis.RealEstateManagementSystem.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	UserCommonDetailsRepository userCommonDetailsRepo;
    @Autowired
    private SellerRepository sellerRepo;

    @Autowired
    private PropertyManagerRepository propertyManagerRepo;

    @Autowired
    private BuyerRepository buyerRepo;
    
    public boolean addUser(User user, UserCommonDetails userCommonDetails) {
        
        switch(user.getRole()) {
            case "PROPERTYMANAGER":
                PropertyManager manager = new PropertyManager();
                manager.setUcd(userCommonDetails);
                manager.setUser(user);
                propertyManagerRepo.save(manager);
                break;
            case "SELLER":
                Seller seller = new Seller();
                seller.setUserCommonDetails(userCommonDetails);
                seller.setUser(user);
                sellerRepo.save(seller);
                break;
            case "BUYER":
                Buyer buyer = new Buyer();
                buyer.setUserCommonDetails(userCommonDetails);
                buyer.setUser(user);
                buyerRepo.save(buyer);
                break;
            case "ADMIN":
                Admin admin = new Admin();
                admin.setUserComDet(userCommonDetails);
                admin.setUser(user);
                adminRepo.save(admin);
                break;
            default:
                return false;
        }
        return true;
    }
    
    @Transactional
    public boolean updateUser(User user, UserCommonDetails userCommonDetails) {
        switch(user.getRole()) {
            case "PROPERTYMANAGER":
                Optional<PropertyManager> optionalManager = propertyManagerRepo.findById(user.getUserId());
                if (optionalManager.isPresent()) {
                    PropertyManager manager = optionalManager.get();
                    manager.setUcd(userCommonDetails);
                    manager.setUser(user);
                    propertyManagerRepo.save(manager);
                } else {
                    return false;
                }
                break;
            case "SELLER":
                Optional<Seller> optionalSeller = sellerRepo.findByUserId(user.getUserId());
                if (optionalSeller.isPresent()) {
                    Seller seller = optionalSeller.get();
                    seller.setUserCommonDetails(userCommonDetails);
                    seller.setUser(user);
                    sellerRepo.save(seller);
                } else {
                    return false;
                }
                break;
            case "BUYER":
            	System.out.println(user.getUserId());
                Optional<Buyer> optionalBuyer = buyerRepo.findByUserId(user.getUserId());
                if (optionalBuyer.isPresent()) {
                    Buyer buyer = optionalBuyer.get();
                    buyer.setUserCommonDetails(userCommonDetails);
                    buyer.setUser(user);
                    buyerRepo.save(buyer);
                } else {
                    return false;
                }
                break;
            case "ADMIN":
                Optional<Admin> optionalAdmin = adminRepo.findById(user.getUserId());
                if (optionalAdmin.isPresent()) {
                    Admin admin = optionalAdmin.get();
                    admin.setUserComDet(userCommonDetails);
                    admin.setUser(user);
                    adminRepo.save(admin);
                } else {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public UserRequest checkUser(String email,String pwd) {
    	User user = userRepo.checkUser(email, pwd);
        
        if (user != null) {
            UserCommonDetails userCommonDetails = userCommonDetailsRepo.findByUserId(user.getUserId());
            
            // You can create a custom response object to include user and userCommonDetails
            return new UserRequest(user, userCommonDetails);
        } else {
            return null;
        }
//		return userRepo.checkUser(email, pwd);
	}
//	public List<User> getAllUser(){
//		return userRepo.findAll();
//	}
//	public User getUser(int userId) {
//		if(userRepo.existsById(userId)) 
//			return userRepo.findById(userId).get();
//		return null;
//	}
//	public User addUser(User user) {
//		if(userRepo.save(user)!=null)
//			return user;
//		return null;
//	}
//	public User updateUser(User user) {
//		if(userRepo.existsById(user.getUserId()))
//			return userRepo.save(user);
//		return null;
//	}
//	public User deleteUser(int userId) {
//		if(userRepo.existsById(userId)){
//			User user=userRepo.findById(userId).get();
//			userRepo.deleteById(userId);
//			return user;
//		}
//		return null;
//	}

}
