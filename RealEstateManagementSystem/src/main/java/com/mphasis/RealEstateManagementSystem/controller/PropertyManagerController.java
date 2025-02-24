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

import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.service.PropertyManagerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/property_manager")
public class PropertyManagerController {
	@Autowired
	PropertyManagerService propServ;
	@PostMapping("/add")
	public ResponseEntity<?> addPropertyManager(@RequestBody PropertyManager porpManager) {
		if(propServ.addPropertyManager(porpManager)!=null)
			return new ResponseEntity<PropertyManager>(porpManager,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry PropertyManager Id Already Exists.",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatePropertyManager(@PathVariable("id") int propManagerId, @RequestBody PropertyManager porpManager) {
		if(propServ.getPropertyManager(propManagerId).getPropManagerid()==propManagerId) {
			propServ.updatePropertyManager(porpManager);
			return new ResponseEntity<PropertyManager>(porpManager,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Sorry PropertyManager does not Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public ResponseEntity<?> getAllPropertyManagers() {
		List<PropertyManager> propManList=propServ.getAllPropertyManager();
		if(!propManList.isEmpty())
			return new ResponseEntity<List<PropertyManager>>(propManList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No PropertyManagers Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getPropertyManager(@PathVariable("id") int propManagerId) {
		PropertyManager porpManager=propServ.getPropertyManager(propManagerId);
		if(porpManager!=null)
			return new ResponseEntity<PropertyManager>(porpManager,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry PropertyManager does not Exists.",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deletePropertyManager(@PathVariable("id") int propManagerId) {
		PropertyManager porpManager=propServ.deletePropertyManager(propManagerId);
		if(porpManager!=null)
			return new ResponseEntity<PropertyManager>(porpManager,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry PropertyManager does not Exists.",HttpStatus.NOT_FOUND);
	}
}
