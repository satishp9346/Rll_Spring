package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.repository.PropertyManagerRepository;

@Service
public class PropertyManagerService {
	@Autowired
	PropertyManagerRepository propManRepo;
	public List<PropertyManager> getAllPropertyManager(){
		return propManRepo.findAll();
	}
	public PropertyManager getPropertyManager(int propManagerid) {
		if(propManRepo.existsById(propManagerid)) 
			return propManRepo.findById(propManagerid).get();
		return null;
	}
	public PropertyManager addPropertyManager(PropertyManager propManager) {
		if(propManRepo.save(propManager)!=null)
			return propManager;
		return null;
	}
	public PropertyManager updatePropertyManager(PropertyManager propManager) {
		if(propManRepo.existsById(propManager.getPropManagerid()))
			return propManRepo.save(propManager);
		return null;
	}
	public PropertyManager deletePropertyManager(int propManagerid) {
		if(propManRepo.existsById(propManagerid)){
			PropertyManager propManager=propManRepo.findById(propManagerid).get();
			propManRepo.deleteById(propManagerid);
			return propManager;
		}
		return null;
	}
}
