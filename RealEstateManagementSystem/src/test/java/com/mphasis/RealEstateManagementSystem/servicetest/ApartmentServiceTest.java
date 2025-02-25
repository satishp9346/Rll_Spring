package com.mphasis.RealEstateManagementSystem.servicetest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mphasis.RealEstateManagementSystem.dto.ApartmentDTO;
import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.CommonPropertyDetails;
import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.repository.ApartmentRepository;
import com.mphasis.RealEstateManagementSystem.repository.UserRepository;
import com.mphasis.RealEstateManagementSystem.service.ApartmentService;

import jakarta.persistence.EntityManager;

@ExtendWith(MockitoExtension.class)
class ApartmentServiceTest {

    @Mock
    private ApartmentRepository apartRepo;

    @Mock
    private UserRepository userRepository;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private ApartmentService apartmentService;

    private Apartment apartment;
    private Seller seller;
    private Buyer buyer;
    private PropertyManager propertyManager;
    private CommonPropertyDetails commonPropertyDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        seller = new Seller();
        buyer = new Buyer();
        propertyManager = new PropertyManager();
        commonPropertyDetails = new CommonPropertyDetails();
        commonPropertyDetails.setSoldStatus("unsold");
        
        apartment = new Apartment();
        apartment.setApartmentId(1);
        apartment.setApartmentName("Luxury Apartment");
        apartment.setSeller(seller);
        apartment.setBuyer(null);
        apartment.setCommPropDetails(commonPropertyDetails);
    }

    @Test
    void testGetAllApartment() {
        when(apartRepo.findAll()).thenReturn(Arrays.asList(apartment));
        List<Apartment> apartments = apartmentService.getAllApartment();
        assertNotNull(apartments);
        assertEquals(1, apartments.size());
        verify(apartRepo, times(1)).findAll();
    }

    @Test
    void testGetApartment_Found() {
        when(apartRepo.existsById(1)).thenReturn(true);
        when(apartRepo.findById(1)).thenReturn(Optional.of(apartment));

        Apartment result = apartmentService.getApartment(1);
        assertNotNull(result);
        assertEquals("Luxury Apartment", result.getApartmentName());
    }

    @Test
    void testGetApartment_NotFound() {
        when(apartRepo.existsById(2)).thenReturn(false);
        Apartment result = apartmentService.getApartment(2);
        assertNull(result);
    }

    @Test
    void testAddApartment() {
        ApartmentDTO apartmentDTO = new ApartmentDTO();
        apartmentDTO.setApartmentName("New Apartment");
        apartmentDTO.setSeller(seller);
        apartmentDTO.setPropertyManager(propertyManager);
        apartmentDTO.setCommonPropertyDetails(commonPropertyDetails);

        when(entityManager.merge(any(PropertyManager.class))).thenReturn(propertyManager);
        when(apartRepo.save(any(Apartment.class))).thenReturn(apartment);
        
        Apartment savedApartment = apartmentService.addApartment(apartmentDTO);
        assertNotNull(savedApartment);
        assertEquals("Luxury Apartment", savedApartment.getApartmentName());
    }

    @Test
    void testUpdateApartment_Success() {
        when(apartRepo.existsById(1)).thenReturn(true);
        when(apartRepo.save(any(Apartment.class))).thenReturn(apartment);
        
        Apartment updatedApartment = apartmentService.updateApartment(apartment);
        assertNotNull(updatedApartment);
        assertEquals("Luxury Apartment", updatedApartment.getApartmentName());
    }

    @Test
    void testUpdateApartment_NotFound() {
        when(apartRepo.existsById(2)).thenReturn(false);
        Apartment updatedApartment = apartmentService.updateApartment(apartment);
        assertNull(updatedApartment);
    }

    @Test
    void testDeleteApartment_Success() {
        when(apartRepo.existsById(1)).thenReturn(true);
        when(apartRepo.findById(1)).thenReturn(Optional.of(apartment));
        
        Apartment deletedApartment = apartmentService.deleteApartment(1);
        assertNotNull(deletedApartment);
        assertEquals("Luxury Apartment", deletedApartment.getApartmentName());
        verify(apartRepo, times(1)).deleteById(1);
    }

    @Test
    void testDeleteApartment_NotFound() {
        when(apartRepo.existsById(2)).thenReturn(false);
        Apartment deletedApartment = apartmentService.deleteApartment(2);
        assertNull(deletedApartment);
        verify(apartRepo, never()).deleteById(2);
    }

    @Test
    void testMarkApartmentAsSold() {
        when(apartRepo.findById(1)).thenReturn(Optional.of(apartment));
        when(entityManager.find(Buyer.class, buyer.getBuyerId())).thenReturn(buyer);
        
        apartmentService.markApartmentAsSold(1, buyer);
        
        assertEquals("sold", apartment.getCommPropDetails().getSoldStatus());
        assertEquals(buyer, apartment.getBuyer());
        verify(apartRepo, times(1)).save(apartment);
    }

    @Test
    void testGetUnsoldApartments() {
        when(apartRepo.getUnsoldApartments()).thenReturn(Arrays.asList(apartment));
        List<Apartment> unsoldApartments = apartmentService.getUnsoldApartments();
        assertNotNull(unsoldApartments);
        assertEquals(1, unsoldApartments.size());
    }
}
