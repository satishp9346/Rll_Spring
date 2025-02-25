package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.repository.ApartmentRepository;
import com.mphasis.RealEstateManagementSystem.repository.PlotsRepository;
import com.mphasis.RealEstateManagementSystem.repository.PropertyRepository;
import com.mphasis.RealEstateManagementSystem.repository.VillaRepository;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private PlotsRepository plotsRepository;

    @Autowired
    private VillaRepository villaRepository;

    public List<?> getPropertyDetails(String propertyType) {
        switch (propertyType.toLowerCase()) {
            case "apartment":
                return apartmentRepository.findApartmentsByStatus();

            case "plot":
                return plotsRepository.findPlotsByStatus();

            case "villa":
                return villaRepository.findVillaByStatus();

            default:
                throw new IllegalArgumentException("Invalid property type: " + propertyType);
        }
    }
}
