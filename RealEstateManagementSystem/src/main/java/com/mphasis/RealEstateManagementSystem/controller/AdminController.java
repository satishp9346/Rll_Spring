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

import com.mphasis.RealEstateManagementSystem.entity.Admin;
import com.mphasis.RealEstateManagementSystem.service.AdminService;


@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminServ;
	@PostMapping("/add")
	public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
		if(adminServ.addAdmin(admin)!=null)
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Admin Id Already Exists.",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable("id") int adminId, @RequestBody Admin admin) {
		if(adminServ.getAdmin(adminId).getAdminId()==adminId) {
			adminServ.updateAdmin(admin);
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Sorry Admin does not Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public ResponseEntity<?> getAllAdmins() {
		List<Admin> adminList=adminServ.getAllAdmin();
		if(!adminList.isEmpty())
			return new ResponseEntity<List<Admin>>(adminList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Admins Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable("id") int adminId) {
		Admin admin=adminServ.getAdmin(adminId);
		if(admin!=null)
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Admin does not Exists.",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") int adminId) {
		Admin admin=adminServ.deleteAdmin(adminId);
		if(admin!=null)
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Admin does not Exists.",HttpStatus.NOT_FOUND);
	}
}
