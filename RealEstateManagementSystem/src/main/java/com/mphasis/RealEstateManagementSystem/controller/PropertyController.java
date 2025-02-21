package com.mphasis.RealEstateManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.RealEstateManagementSystem.service.PropertyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

//    @PostMapping("/add")
//    public ResponseEntity<CommonPropertyDetails> addProperty(
//            @RequestBody CommonPropertyDetails propertyDetails,
//            @RequestParam String propertyType) {
//        try {
//            CommonPropertyDetails savedProperty = propertyService.addProperty(propertyDetails, propertyType);
//            return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
    
    @GetMapping("/details")
    public ResponseEntity<?> getPropertyDetails(String propertyType) {
        try {
            List<?> propertyDetails = propertyService.getPropertyDetails(propertyType);
            return new ResponseEntity<>(propertyDetails, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}


