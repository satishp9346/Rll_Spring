package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.entity.Admin;
import com.mphasis.RealEstateManagementSystem.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepo;
	public List<Admin> getAllAdmin(){
		return adminRepo.findAll();
	}
	public Admin getAdmin(int adminId) {
		if(adminRepo.existsById(adminId)) 
			return adminRepo.findById(adminId).get();
		return null;
	}
	public Admin addAdmin(Admin admin) {
		if(adminRepo.save(admin)!=null)
			return admin;
		return null;
	}
	public Admin updateAdmin(Admin admin) {
		if(adminRepo.existsById(admin.getAdminId()))
			return adminRepo.save(admin);
		return null;
	}
	public Admin deleteAdmin(int adminId) {
		if(adminRepo.existsById(adminId)){
			Admin admin=adminRepo.findById(adminId).get();
			adminRepo.deleteById(adminId);
			return admin;
		}
		return null;
	}
}
