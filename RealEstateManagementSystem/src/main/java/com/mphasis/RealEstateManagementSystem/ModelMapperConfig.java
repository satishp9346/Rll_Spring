package com.mphasis.RealEstateManagementSystem;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mphasis.RealEstateManagementSystem.dto.ApartmentDTO;
import com.mphasis.RealEstateManagementSystem.dto.BuyerDTO;
import com.mphasis.RealEstateManagementSystem.dto.CommonPropertyDetailsDTO;
import com.mphasis.RealEstateManagementSystem.dto.PropertyManagerDTO;
import com.mphasis.RealEstateManagementSystem.dto.SellerDTO;
import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.entity.Seller;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Define custom mappings for Apartment to ApartmentDTO
        modelMapper.addMappings(new PropertyMap<Apartment, ApartmentDTO>() {
            @Override
            protected void configure() {
                // Here you can specify any custom mapping logic if needed
                // Example: custom mapping logic between nested properties
            }
        });
        
        modelMapper.addMappings(new PropertyMap<CommonPropertyDetails, CommonPropertyDetailsDTO>() {
            @Override
            protected void configure() {
                // Here you can specify any custom mapping logic if needed
                // Example: custom mapping logic between nested properties
            }
        });
        
        modelMapper.addMappings(new PropertyMap<Seller, SellerDTO>() {
            @Override
            protected void configure() {
                // Here you can specify any custom mapping logic if needed
                // Example: custom mapping logic between nested properties
            }
        });
        modelMapper.addMappings(new PropertyMap<Buyer, BuyerDTO>() {
            @Override
            protected void configure() {
                // Here you can specify any custom mapping logic if needed
                // Example: custom mapping logic between nested properties
            }
        });
        modelMapper.addMappings(new PropertyMap<Seller, SellerDTO>() {
            @Override
            protected void configure() {
                // Here you can specify any custom mapping logic if needed
                // Example: custom mapping logic between nested properties
            }
        });
        modelMapper.addMappings(new PropertyMap<PropertyManager, PropertyManagerDTO>() {
            @Override
            protected void configure() {
                // Here you can specify any custom mapping logic if needed
                // Example: custom mapping logic between nested properties
            }
        });

        // Add custom mappings for other entities as required, such as Seller, Buyer, etc.
        
        return modelMapper;
    }
}

